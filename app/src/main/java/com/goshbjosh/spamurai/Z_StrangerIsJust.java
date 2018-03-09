package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 3/8/18.
 */

public class Z_StrangerIsJust extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_stranger_is_just);




        // BUTTON -  Seems Legit
        final Button oneButton = (Button) findViewById(R.id.button_one);

        oneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goOne = new Intent(Z_StrangerIsJust.this, Z_SeemsLegit.class);
                Z_StrangerIsJust.this.startActivity(goOne);
            }
        });


        // BUTTON -  Ask a Manager
        final Button twoButton = (Button) findViewById(R.id.button_two);

        twoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goTwo = new Intent(Z_StrangerIsJust.this, Z_AskMyManager.class);
                Z_StrangerIsJust.this.startActivity(goTwo);
            }
        });


        // BUTTON -  Back
        final Button backButton = (Button) findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_StrangerIsJust.this, Z_GrossButOnWith.class);
                Z_StrangerIsJust.this.startActivity(goBack);
            }
        });




    }
}

