package org.spamurai.spamurai;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MarkAsSpam extends AppCompatActivity {
    private PopupWindow popWin;
    private void showPopupWin() {
        try {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popwin, (ViewGroup) findViewById(R.id.popup));

            popWin = new PopupWindow(layout, 290, 360, true);
            popWin.showAtLocation(layout, Gravity.CENTER, 0, 0);
            Button exit_popupWin = (Button) layout.findViewById(R.id.exit_popup);
            exit_popupWin.setOnClickListener(cancel_button);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    private View.OnClickListener cancel_button = new View.OnClickListener() {
        public void onClick(View v) {
            popWin.dismiss();
        }
    };

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
        RadioGroup markSpamGroup = (RadioGroup) findViewById(R.id.radio_markspamgroup);
        markSpamGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (checkedId == R.id.radio_marknotspam) {
                    Toast.makeText(getApplicationContext(), "Number DOES NOT match", Toast.LENGTH_SHORT).show();
                    showPopupWin();
                }
                if (checkedId == R.id.radio_markspam) {
                    Toast.makeText(getApplicationContext(), "Number DOES match", Toast.LENGTH_SHORT).show();

                }
            }
        });
//
//


//        public void markSpamGroup (View view) {
//            // Is the button now checked?
//            boolean checked = ((RadioButton) view).isChecked();
//            Button exit_popupWin;
//            // Check which radio button was clicked
//
//            }
//        }


        final Button checkRegistry = (Button)findViewById(R.id.checkRegistry);

        checkRegistry.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "https://www.donotcall.gov/confirm/conf.aspx";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

        });

        final Button reportNumber = (Button)findViewById(R.id.reportNumber);

        reportNumber.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String url = "https://complaints.donotcall.gov/complaint/complaintcheck.aspx";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }

        });

            }
}