package org.spamurai.spamurai;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // CONNECT 'MarkAsSpam' ACTIVITY
        final Button markAsSpamButton = (Button)findViewById(R.id.button_markCall);

        markAsSpamButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToMarkAsSpam = new Intent(MainActivity.this, MarkAsSpam.class);
                MainActivity.this.startActivity(goToMarkAsSpam);
            }
        });


        // CONNECT 'CALLREVIEW' ACTIVITY
        final Button ringerOptionsButton = (Button)findViewById(R.id.button_ringerOptions);

        ringerOptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToringerOptions = new Intent(MainActivity.this, RingerOptions.class);
                MainActivity.this.startActivity(goToringerOptions);
            }
        });


    }
}
