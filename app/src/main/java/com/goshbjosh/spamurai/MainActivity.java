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


        // BUTTON - Play Game
        final Button playGameButton = (Button)findViewById(R.id.button_playGame);

        playGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToGame = new Intent(MainActivity.this, Z_BackStory.class);
                MainActivity.this.startActivity(goToGame);
            }
        });


        // BUTTON - Ringer Options
        final Button ringerOptionsButton = (Button)findViewById(R.id.button_ringerOptions);

        ringerOptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToRingerOptions = new Intent(MainActivity.this, RingerOptions.class);
                MainActivity.this.startActivity(goToRingerOptions);
            }
        });


    }
}
