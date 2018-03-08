package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 3/7/18.
 */

public class Z_GrossButOnWith extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_gross_but);




        // BUTTON -  'Stranger Danger'
        final Button strangerDangerButton = (Button) findViewById(R.id.button_grossButOn);

        strangerDangerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToGross = new Intent(Z_GrossButOnWith.this, Z_Gross.class);
                Z_GrossButOnWith.this.startActivity(goToGross);
            }
        });


        // BUTTON -  'Stranger is Just a Friend'
        final Button grossButton = (Button) findViewById(R.id.button_grossButOn);

        grossButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToGross = new Intent(Z_GrossButOnWith.this, Z_Gross.class);
                Z_GrossButOnWith.this.startActivity(goToGross);
            }
        });


        // BUTTON -  'Back'
        final Button homeButton = (Button) findViewById(R.id.button_back);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_GrossButOnWith.this, Z_BackStory.class);
                Z_GrossButOnWith.this.startActivity(goBack);
            }
        });




    }
}
