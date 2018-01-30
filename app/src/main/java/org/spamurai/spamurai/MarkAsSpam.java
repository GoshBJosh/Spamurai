package org.spamurai.spamurai;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private void showPopupWin(String thisButton) {
        try {
            LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popwin, (ViewGroup) findViewById(R.id.popup));

            popWin = new PopupWindow(layout, 290, 360, true);
            popWin.showAtLocation(layout, Gravity.CENTER, 0, 0);

            if(thisButton == "spam"){

//                Button reportNumber = (Button)findViewById(R.id.reportNumber);
//                reportNumber.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        String url = "https://complaints.donotcall.gov/complaint/complaintcheck.aspx";
//                        Intent i = new Intent(Intent.ACTION_VIEW);
//                        i.setData(Uri.parse(url));
//                        startActivity(i);
//                    }
//                });


            }
            if(thisButton == "notspam"){

                Button addContact = (Button)findViewById(R.id.addContact);
                addContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String url = "https://complaints.donotcall.gov/complaint/complaintcheck.aspx";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });

            }

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









        // MARK AS SPAM, UNKNOWN, NOT SPAM
        RadioGroup markSpamGroup = (RadioGroup) findViewById(R.id.radio_markspamgroup);
        markSpamGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (checkedId == R.id.radio_notspam) {
                    Toast.makeText(getApplicationContext(), "Number DOES NOT match", Toast.LENGTH_SHORT).show();
                    showPopupWin("notspam");
                }
                if (checkedId == R.id.radio_spam) {
                    Toast.makeText(getApplicationContext(), "Number DOES match", Toast.LENGTH_SHORT).show();
                    showPopupWin("spam");

                    // ADDS 1 TO TOTAL NUMBER OF REPORTED CALLS IN SHARED PREFERENCES
//                    public void incrementTotal(View view) {
//                        SharedPreferences sharedPref = getSharedPreferences("reportTotal", Context.MODE_PRIVATE);
//
//                        SharedPreferences.Editor editor = sharedPref.edit();
//                        editor.putInt("reportTotal", 0);
//                        editor.apply();
//                    }

                    int count = 0;
                    SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                    int defaultValue = getPreferences(MODE_PRIVATE).getInt("count_key",count);
                    ++defaultValue;
                    getPreferences(MODE_PRIVATE).edit().putInt("count_key",defaultValue).commit();
                    count = getPreferences(MODE_PRIVATE).getInt("count_key",count);
                    System.out.println("The count value is " + count);



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


    }
}