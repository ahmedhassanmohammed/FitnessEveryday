package app.sunshine.com.example.android.fitnesseveryday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
History extends AppCompatActivity {


    @BindView(R.id.Add_button)
    Button addButton;
    @BindView(R.id.Clear_button)
    Button clearButton;
    @BindView(R.id.Title_EditText)
    EditText Title;
    @BindView(R.id.Step_Edittext)
    EditText Step;
    @BindView(R.id.note_ListView)
    ListView noteslistView;
//        @BindView(R.id.todaydate)
//    TextView todaydate;
    NotesAdapter adapter;
    //  db1
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;

    //  read from db
    ChildEventListener mChildEventListner;

    // auth
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
//        noteslistView = (ListView) findViewById(R.id.note_ListView);


        // Initialize message ListView and its adapter
        List<Note> List_of_notes = new ArrayList<>();
        adapter = new NotesAdapter(this, R.layout.list_item, List_of_notes);
        noteslistView.setAdapter(adapter);

        // ahmed hassan db2
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null)
//            return null;
        String currentUserEmail = user.getEmail().replace(".", "_");
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("message/" + currentUserEmail);

//        addButton = (Button) findViewById(R.id.Add_button);
//        clearButton = (Button) findViewById(R.id.Clear_button);
//        Title = (EditText) findViewById(R.id.Title_EditText);
//        Step = (EditText) findViewById(R.id.Step_Edittext);


        // to read from db

        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // snapshot de byeb2a feha kol 7aga enta katabtha hata5odha wt7otha f class wel adapter hay7ot f el listview
                Note note = dataSnapshot.getValue(Note.class);
                adapter.add(note);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mMessagesDatabaseReference.addChildEventListener(mChildEventListner);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Title.getText().toString().equals("") || Step.getText().toString().equals("")) {
                    Toast.makeText(History.this, R.string.req_not_complete, Toast.LENGTH_SHORT).show();
                } else {

                    String title = Title.getText().toString();
                    String step = Step.getText().toString();
//




                    Note note = new Note(title, step);
                    mMessagesDatabaseReference.push().setValue(note);


                    Toast.makeText(History.this, R.string.Note_Added_Successfull, Toast.LENGTH_LONG).show();
                    Title.setText("");
                    Step.setText("");
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessagesDatabaseReference.removeValue();
                adapter.clear();
                adapter.notifyDataSetChanged();
//                mMessagesDatabaseReference.addChildEventListener(mChildEventListner);
            }
        });
    }
}
