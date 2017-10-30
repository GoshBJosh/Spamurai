package org.spamurai.spamurai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MarkAsSpam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_as_spam);


        // CHECK CURRENT STATUS. DISPLAY WHAT CALL IS SAVED AS.
            // gets number from last activity
        Intent intent = getIntent();
        String numberReview = intent.getStringExtra("key");


        // NEED TO GET USER'S CHARACTER LEVEL TO DISPLAY THEIR AVATAR








        // MARK AS SPAM, UNKNOWN, NOT SPAM
        final RadioGroup markSpamGroup = (RadioGroup) findViewById(R.id.radio_markspamgroup);

        markSpamGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get selected radio button from radioGroup
                int selectedId = markSpamGroup.getCheckedRadioButtonId();
                // find the radiobutton by returned id
                RadioButton thisMarkedOption = (RadioButton) findViewById(selectedId);

                Toast.makeText(getApplicationContext(), thisMarkedOption.getText(), Toast.LENGTH_SHORT).show();

            }

        });




    }
}