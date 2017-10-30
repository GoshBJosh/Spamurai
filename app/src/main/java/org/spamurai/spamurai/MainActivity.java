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


       // PROTECTION SWITCH ON/OFF
       Switch protectionSwitch = (Switch) findViewById(R.id.protectionSwitch);

       protectionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (buttonView.isChecked()){
                   ComponentName component = new ComponentName(getApplicationContext(), PhoneStateReceiver.class);
                   getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager. COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
               }
               else{
                   ComponentName component = new ComponentName(getApplicationContext(), PhoneStateReceiver.class);
                   getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager. COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
               }
           }
       });


        // CONNECT 'CALLREVIEW' ACTIVITY
        final Button callReviewButton = (Button)findViewById(R.id.callReviewButton);

        callReviewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToCallReview = new Intent(MainActivity.this, CallReview.class);
                MainActivity.this.startActivity(goToCallReview);
            }
        });




    }


}
