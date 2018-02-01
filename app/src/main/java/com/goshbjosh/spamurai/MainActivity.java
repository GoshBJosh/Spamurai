package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // CONNECT 'MarkAsSpam' ACTIVITY
        final Button callReviewButton = (Button)findViewById(R.id.button_markCall);

        callReviewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToCallReview = new Intent(MainActivity.this, CallReview.class);
                MainActivity.this.startActivity(goToCallReview);
            }
        });


        // CONNECT 'CALLREVIEW' ACTIVITY
        final Button ringerOptionsButton = (Button)findViewById(R.id.button_ringerOptions);

        ringerOptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToRingerOptions = new Intent(MainActivity.this, RingerOptions.class);
                MainActivity.this.startActivity(goToRingerOptions);
            }
        });


    }
}
