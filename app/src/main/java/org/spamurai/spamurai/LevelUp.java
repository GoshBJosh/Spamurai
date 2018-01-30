package org.spamurai.spamurai;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LevelUp extends AppCompatActivity {

    TextView displayTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        // PRINT 'TOTAL CALLS REPORTED'
        displayTotal = (TextView) findViewById(R.id.text_number);
        SharedPreferences sharedPref = getSharedPreferences("reportTotal", Context.MODE_PRIVATE);

        int total = sharedPref.getInt("reportTotal", 0);
        displayTotal.setText(total);



        // CONNECT 'MainActivity' ACTIVITY
        final Button homeButton = (Button) findViewById(R.id.button_home);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToHome = new Intent(LevelUp.this, MainActivity.class);
                LevelUp.this.startActivity(goToHome);
            }
        });




    }

}
