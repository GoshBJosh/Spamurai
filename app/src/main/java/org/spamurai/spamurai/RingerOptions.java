package org.spamurai.spamurai;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;


public class RingerOptions extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringer_options);

        // PROTECTION SWITCH ON/OFF
        final Switch protectionSwitch = (Switch) findViewById(R.id.switch_ringerOnOff);

        protectionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()) {
                    ComponentName component = new ComponentName(getApplicationContext(), PhoneStateReceiver.class);
                    getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                } else {
                    ComponentName component = new ComponentName(getApplicationContext(), PhoneStateReceiver.class);
                    getApplicationContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                }
            }
        });


    }
}
