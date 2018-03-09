package com.goshbjosh.spamurai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by josh on 3/8/18.
 */

public class Z_SeemsLegit extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z_seems_legit);




        // BUTTON -  Let's See Where This Goes...
        final Button oneButton = (Button) findViewById(R.id.button_one);

        oneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goOne = new Intent(Z_SeemsLegit.this, Z_SeeWhereThisGoes.class);
                Z_SeemsLegit.this.startActivity(goOne);
            }
        });


        // BUTTON -  Let's 'Nope' Right Out of There
        final Button twoButton = (Button) findViewById(R.id.button_one);

        twoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goTwo = new Intent(Z_SeemsLegit.this, Z_NopeRightOut.class);
                Z_SeemsLegit.this.startActivity(goTwo);
            }
        });


        // BUTTON -  Back
        final Button backButton = (Button) findViewById(R.id.button_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goBack = new Intent(Z_SeemsLegit.this, Z_StrangerIsJust.class);
                Z_SeemsLegit.this.startActivity(goBack);
            }
        });




    }
}

