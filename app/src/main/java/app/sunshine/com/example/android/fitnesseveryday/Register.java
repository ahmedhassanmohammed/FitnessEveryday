package app.sunshine.com.example.android.fitnesseveryday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity {
    private static final String TAG = "registeractivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @BindView(R.id.reg_input_email)
    EditText email;
    @BindView(R.id.Reg_input_password)
    EditText password;
    @BindView(R.id.Reg_input_name)
    EditText name;
    @BindView(R.id.btn_signup)
    Button sign_up;
    @BindView(R.id.link_login)
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();
//        sign_up = (Button) findViewById(R.id.btn_signup);
//        email = (EditText) findViewById(R.id.reg_input_email);
//        name = (EditText) findViewById(R.id.Reg_input_name);
//        password = (EditText) findViewById(R.id.Reg_input_password);
//        login = (TextView) findViewById(R.id.link_login);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String myemail = email.getText().toString();
                String pass = password.getText().toString();
                String myname = name.getText().toString();
                if (myemail.equals("") || pass.equals("") || myname.equals(""))
                    Toast.makeText(Register.this,R.string.fill_all, Toast.LENGTH_SHORT).show();
                else {
                    mAuth.createUserWithEmailAndPassword(myemail, pass)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        Toast.makeText(Register.this, R.string.Reg_succ, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Register.this, MainActivity.class);
                                        startActivity(intent);


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(Register.this, R.string.auth_failed,
                                                Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (mAuthListener != null) {
//            mAuth.removeAuthStateListener(mAuthListener);
//        }
//    }

}
