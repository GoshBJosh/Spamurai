package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 3/7/18.
 */

public class Z_BackStory extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_back_story);




        // BUTTON - 'Gross, but on with the story'
        final Button grossButton = (Button) findViewById(R.id.button_grossButOn);

        grossButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToGross = new Intent(Z_BackStory.this, Z_GrossButOnWith.class);
                Z_BackStory.this.startActivity(goToGross);
            }
        });

        // BUTTON - 'Back'
        final Button backButton = (Button) findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_BackStory.this, MainActivity.class);
                Z_BackStory.this.startActivity(goBack);
            }
        });




    }
}
