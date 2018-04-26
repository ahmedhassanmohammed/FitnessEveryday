package app.sunshine.com.example.android.fitnesseveryday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.arm)
    Button arm;
    @BindView(R.id.back)
    Button back;
    @BindView(R.id.chest)
    Button chest;
    @BindView(R.id.core)
    Button core;
    @BindView(R.id.shoulder)
    Button shoulder;
    @BindView(R.id.historybutton)
    Button historybutton;
    @BindView(R.id.sign_out)
    TextView sign_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
//        arm = (Button) findViewById(R.id.arm);
//        back = (Button) findViewById(R.id.back);
//        chest = (Button) findViewById(R.id.chest);
//        core = (Button) findViewById(R.id.core);
//        shoulder = (Button) findViewById(R.id.shoulder);
//        sign_out = (TextView) findViewById(R.id.sign_out);
//        historybutton = (Button) findViewById(R.id.historybutton);


        historybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, History.class);
                startActivity(intent);
            }
        });


        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arm.class);
                intent.putExtra("key", "arm");
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arm.class);
                intent.putExtra("key", "back");
                startActivity(intent);
            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arm.class);
                intent.putExtra("key", "chest");
                startActivity(intent);
            }
        });
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arm.class);
                intent.putExtra("key", "core");
                startActivity(intent);
            }
        });
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Arm.class);
                intent.putExtra("key", "shoulder");
                startActivity(intent);
            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
