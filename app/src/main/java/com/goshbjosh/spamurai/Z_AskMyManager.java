package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 3/8/18.
 */

public class Z_AskMyManager extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_ask_my_manager);




        // BUTTON -  Home
        final Button oneButton = (Button) findViewById(R.id.button_one);

        oneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goOne = new Intent(Z_AskMyManager.this, MainActivity.class);
                Z_AskMyManager.this.startActivity(goOne);
            }
        });


        // BUTTON -  Back
        final Button backButton = (Button) findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_AskMyManager.this, Z_StrangerIsJust.class);
                Z_AskMyManager.this.startActivity(goBack);
            }
        });




    }
}