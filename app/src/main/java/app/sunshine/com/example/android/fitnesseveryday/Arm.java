package app.sunshine.com.example.android.fitnesseveryday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Arm extends AppCompatActivity {

    @BindView(R.id.step1)
    TextView step1;
    @BindView(R.id.step2)
    TextView step2;
    @BindView(R.id.step3)
    TextView step3;
    @BindView(R.id.step4)
    TextView step4;
    @BindView(R.id.step5)
    TextView step5;

    @BindView(R.id.step1sets)
    TextView step1sets;
    @BindView(R.id.step2sets)
    TextView step2sets;
    @BindView(R.id.step3sets)
    TextView step3sets;
    @BindView(R.id.step4sets)
    TextView step4sets;
    @BindView(R.id.step5sets)
    TextView step5sets;

    @BindView(R.id.step3_details)
    TextView step3_details;
    @BindView(R.id.step4_details)
    TextView step4_details;
    @BindView(R.id.step5_details)
    TextView step5_details;
    @BindView(R.id.step1_details)
    TextView step1_details;
    @BindView(R.id.step2_details)
    TextView step2_details;

    @BindView(R.id.step1_image1)
    ImageView step1_image1;
    @BindView(R.id.step1_image2)
    ImageView step1_image2;
    @BindView(R.id.step2_image1)
    ImageView step2_image1;
    @BindView(R.id.step2_image2)
    ImageView step2_image2;
    @BindView(R.id.step3_image1)
    ImageView step3_image1;
    @BindView(R.id.step3_image2)
    ImageView step3_image2;
    @BindView(R.id.step4_image1)
    ImageView step4_image1;
    @BindView(R.id.step4_image2)
    ImageView step4_image2;
    @BindView(R.id.step5_image1)
    ImageView step5_image1;
    @BindView(R.id.step5_image2)
    ImageView step5_image2;

    @BindView(R.id.fab)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm);
        ButterKnife.bind(this);
//        step1 = (TextView) findViewById(R.id.step1);
//        step1sets = (TextView) findViewById(R.id.step1sets);
//        step1_details = (TextView) findViewById(R.id.step1_details);
//        step1_image1 = (ImageView) findViewById(R.id.step1_image1);
//        step1_image2 = (ImageView) findViewById(R.id.step1_image2);
//
//        step2 = (TextView) findViewById(R.id.step2);
//        step2sets = (TextView) findViewById(R.id.step2sets);
//        step2_details = (TextView) findViewById(R.id.step2_details);
//        step2_image1 = (ImageView) findViewById(R.id.step2_image1);
//        step2_image2 = (ImageView) findViewById(R.id.step2_image2);
//
//        step3 = (TextView) findViewById(R.id.step3);
//        step3sets = (TextView) findViewById(R.id.step3sets);
//        step3_details = (TextView) findViewById(R.id.step3_details);
//        step3_image1 = (ImageView) findViewById(R.id.step3_image1);
//        step3_image2 = (ImageView) findViewById(R.id.step3_image2);
//
//        step4 = (TextView) findViewById(R.id.step4);
//        step4sets = (TextView) findViewById(R.id.step4sets);
//        step4_details = (TextView) findViewById(R.id.step4_details);
//        step4_image1 = (ImageView) findViewById(R.id.step4_image1);
//        step4_image2 = (ImageView) findViewById(R.id.step4_image2);
//
//        step5 = (TextView) findViewById(R.id.step5);
//        step5sets = (TextView) findViewById(R.id.step5sets);
//        step5_details = (TextView) findViewById(R.id.step5_details);
//        step5_image1 = (ImageView) findViewById(R.id.step5_image1);
//        step5_image2 = (ImageView) findViewById(R.id.step5_image2
        Intent intent = getIntent();
        String x = intent.getStringExtra("key");
        if (x.equals("arm")) {
            step1.setText(R.string.EX1_1);
            step1sets.setText(R.string.EX1_2);
            step1_details.setText(R.string.EX1_3);
            step1_image1.setImageResource(R.drawable.a11);
            step1_image2.setImageResource(R.drawable.a12);

            step2.setText(R.string.EX2_1);
            step2sets.setText(R.string.EX2_2);
            step2_details.setText(R.string.EX2_3);
            step2_image1.setImageResource(R.drawable.a21);
            step2_image2.setImageResource(R.drawable.a22);

            step3.setText(R.string.EX3_1);
            step3sets.setText(R.string.EX3_2);
            step3_details.setText(R.string.EX3_3);
            step3_image1.setImageResource(R.drawable.a31);
            step3_image2.setImageResource(R.drawable.a32);

            step4.setText(R.string.EX4_1);
            step4sets.setText(R.string.EX4_2);
            step4_details.setText(R.string.EX4_3);
            step4_image1.setImageResource(R.drawable.a41);
            step4_image2.setImageResource(R.drawable.a42);

            step5.setText(R.string.EX5_1);
            step5sets.setText(R.string.EX5_2);
            step5_details.setText(R.string.EX5_3);
            step5_image1.setImageResource(R.drawable.a51);
            step5_image2.setImageResource(R.drawable.a52);

        } else if (x.equals("back")) {

            step1.setText(R.string.EX1_1);
            step1sets.setText(R.string.EX1_2);
            step1_details.setText(R.string.EX1_3);
            step1_image1.setImageResource(R.drawable.b11);
            step1_image2.setImageResource(R.drawable.b12);

            step2.setText(R.string.EX2_1);
            step2sets.setText(R.string.EX2_2);
            step2_details.setText(R.string.EX2_3);
            step2_image1.setImageResource(R.drawable.b21);
            step2_image2.setImageResource(R.drawable.b22);

            step3.setText(R.string.EX3_1);
            step3sets.setText(R.string.EX3_2);
            step3_details.setText(R.string.EX3_3);
            step3_image1.setImageResource(R.drawable.b31);
            step3_image2.setImageResource(R.drawable.b32);

            step4.setText(R.string.EX4_1);
            step4sets.setText(R.string.EX4_2);
            step4_details.setText(R.string.EX4_3);
            step4_image1.setImageResource(R.drawable.b41);
            step4_image2.setImageResource(R.drawable.b42);

            step5.setText(R.string.EX5_1);
            step5sets.setText(R.string.EX5_2);
            step5_details.setText(R.string.EX5_3);
            step5_image1.setImageResource(R.drawable.b51);
            step5_image2.setImageResource(R.drawable.b52);
        } else if (x.equals("chest")) {

            step1.setText(R.string.EX1_1);
            step1sets.setText(R.string.EX1_2);
            step1_details.setText(R.string.EX1_3);
            step1_image1.setImageResource(R.drawable.c11);
            step1_image2.setImageResource(R.drawable.c12);

            step2.setText(R.string.EX2_1);
            step2sets.setText(R.string.EX2_2);
            step2_details.setText(R.string.EX2_3);
            step2_image1.setImageResource(R.drawable.c21);
            step2_image2.setImageResource(R.drawable.c22);

            step3.setText(R.string.EX3_1);
            step3sets.setText(R.string.EX3_2);
            step3_details.setText(R.string.EX3_3);
            step3_image1.setImageResource(R.drawable.c31);
            step3_image2.setImageResource(R.drawable.c32);

            step4.setText(R.string.EX4_1);
            step4sets.setText(R.string.EX4_2);
            step4_details.setText(R.string.EX4_3);
            step4_image1.setImageResource(R.drawable.c41);
            step4_image2.setImageResource(R.drawable.c42);

            step5.setText(R.string.EX5_1);
            step5sets.setText(R.string.EX5_2);
            step5_details.setText(R.string.EX5_3);
            step5_image1.setImageResource(R.drawable.c41);
            step5_image2.setImageResource(R.drawable.c42);
        } else if (x.equals("core")) {

            step1.setText(R.string.EX1_1);
            step1sets.setText(R.string.EX1_2);
            step1_details.setText(R.string.EX1_3);
            step1_image1.setImageResource(R.drawable.co11);
            step1_image2.setImageResource(R.drawable.co12);

            step2.setText(R.string.EX2_1);
            step2sets.setText(R.string.EX2_2);
            step2_details.setText(R.string.EX2_3);
            step2_image1.setImageResource(R.drawable.co21);
            step2_image2.setImageResource(R.drawable.co22);

            step3.setText(R.string.EX3_1);
            step3sets.setText(R.string.EX3_2);
            step3_details.setText(R.string.EX3_3);
            step3_image1.setImageResource(R.drawable.co31);
            step3_image2.setImageResource(R.drawable.co32);

            step4.setText(R.string.EX4_1);
            step4sets.setText(R.string.EX4_2);
            step4_details.setText(R.string.EX4_3);
            step4_image1.setImageResource(R.drawable.co41);
            step4_image2.setImageResource(R.drawable.co42);

            step5.setText(R.string.EX5_1);
            step5sets.setText(R.string.EX5_2);
            step5_details.setText(R.string.EX5_3);
            step5_image1.setImageResource(R.drawable.c11);
            step5_image2.setImageResource(R.drawable.c12);
        } else if (x.equals("shoulder")) {

            step1.setText(R.string.EX1_1);
            step1sets.setText(R.string.EX1_2);
            step1_details.setText(R.string.EX1_3);
            step1_image1.setImageResource(R.drawable.sh11);
            step1_image2.setImageResource(R.drawable.sh12);

            step2.setText(R.string.EX2_1);
            step2sets.setText(R.string.EX2_2);
            step2_details.setText(R.string.EX2_3);
            step2_image1.setImageResource(R.drawable.sh21);
            step2_image2.setImageResource(R.drawable.sh22);

            step3.setText(R.string.EX3_1);
            step3sets.setText(R.string.EX3_2);
            step3_details.setText(R.string.EX3_3);
            step3_image1.setImageResource(R.drawable.sh31);
            step3_image2.setImageResource(R.drawable.sh32);

            step4.setText(R.string.EX4_1);
            step4sets.setText(R.string.EX4_2);
            step4_details.setText(R.string.EX4_3);
            step4_image1.setImageResource(R.drawable.sh41);
            step4_image2.setImageResource(R.drawable.sh42);

            step5.setText(R.string.EX5_1);
            step5sets.setText(R.string.EX5_2);
            step5_details.setText(R.string.EX5_3);
            step5_image1.setImageResource(R.drawable.a11);
            step5_image2.setImageResource(R.drawable.a12);
        }


//        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Arm.this, History.class);
                startActivity(intent);
            }
        });
    }
}
