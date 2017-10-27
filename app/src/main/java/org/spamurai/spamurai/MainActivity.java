package org.spamurai.spamurai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // PROTECTION SWITCH ON/OFF
       Switch protectionSwitch = (Switch) findViewById(R.id.protectionSwitch);

       protectionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (buttonView.isChecked()){
                   Toast.makeText(getApplicationContext(), "SWITCH IS ON", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(), "SWITCH IS OFF", Toast.LENGTH_SHORT).show();
               }
           }
       });

    }


}
