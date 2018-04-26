package app.sunshine.com.example.android.fitnesseveryday.widget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import app.sunshine.com.example.android.fitnesseveryday.Note;
import app.sunshine.com.example.android.fitnesseveryday.R;

/**
 * Created by Ahmed Hassan on 7/22/2017.
 */

public class WidgetListProvider implements RemoteViewsService.RemoteViewsFactory {




    private ArrayList<Note> noteList = new ArrayList();
//    private ArrayList<Note> StepList = new ArrayList();
//    private ArrayList<String> changeList = new ArrayList();

    private Context context;
    private int appWidgetId;
    ChildEventListener mChildEventListner;
    private DatabaseReference mMessagesDatabaseReference;
    FirebaseDatabase mFirebaseDatabase;

    // auth
    FirebaseAuth mAuth;

    public WidgetListProvider(Context context, Intent intent) {
        this.context = context;
        appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
//        if (user == null)
//            return null;
        String currentUserEmail = user.getEmail().replace(".", "_");
        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("message/" + currentUserEmail);

        mChildEventListner = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // snapshot de byeb2a feha kol 7aga enta katabtha hata5odha wt7otha f class wel adapter hay7ot f el listview
                Note note = dataSnapshot.getValue(Note.class);
                noteList.add(note);

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

    }

    @Override
    public void onCreate() {

    }

    /*
    * getView of Adapter where instead of View we return RemoteViews
    */
    @Override
    public RemoteViews getViewAt(int position) {
        final RemoteViews remoteView = new RemoteViews(
                context.getPackageName(), R.layout.list_item);

        remoteView.setTextViewText(R.id.Title, noteList.get(position).getTitle());
        remoteView.setTextViewText(R.id.Step, noteList.get(position).getStep());
//        remoteView.setTextViewText(R.id.change, changeList.get(position));

//        Bundle extras = new Bundle();
////           extras.putInt(StockWidgetProvider.EXTRA_ITEM, position);
//        extras.putString("symbol", noteList.get(position).getTitle());
//        Intent intent = new Intent();
//        intent.putExtras(extras);
//        // Make it possible to distinguish the individual on-click action of a given item
//        remoteView.setOnClickFillInIntent(R.id.list_item, intent);

        return remoteView;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }



    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }}
