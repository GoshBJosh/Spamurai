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
        final Button oneButton = (Button) findViewById(R.id.button_one);

        oneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goOne = new Intent(Z_GrossButOnWith.this, Z_StrangerDanger.class);
                Z_GrossButOnWith.this.startActivity(goOne);
            }
        });


        // BUTTON -  'Stranger is Just a Friend'
        final Button twoButton = (Button) findViewById(R.id.button_two);

        twoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goTwo = new Intent(Z_GrossButOnWith.this, Z_StrangerIsJust.class);
                Z_GrossButOnWith.this.startActivity(goTwo);
            }
        });


        // BUTTON -  'Back'
        final Button backButton = (Button) findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_GrossButOnWith.this, Z_BackStory.class);
                Z_GrossButOnWith.this.startActivity(goBack);
            }
        });




    }
}
