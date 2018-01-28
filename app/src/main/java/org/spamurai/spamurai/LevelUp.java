package org.spamurai.spamurai;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created by JerryCurl on 1/27/2018.
 */

public class LevelUp {

    // CONNECT 'MainActivity' ACTIVITY
    final Button homeButton = (Button)findViewById(R.id.markAsSpamButton);

        markAsSpamButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent goToMarkAsSpam = new Intent(MainActivity.this, MarkAsSpam.class);
            MainActivity.this.startActivity(goToMarkAsSpam);
        }
    });
}
