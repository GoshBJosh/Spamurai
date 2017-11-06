package org.spamurai.spamurai;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;



public class CallReview extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_review);


        // PULL RECENT CALLS INTO ARRAYLIST

        ArrayList<String> nameArray = new ArrayList<String>();
        ArrayList<String> numberArray = new ArrayList<String>();
        ArrayList<String> dateArray = new ArrayList<String>();


//        try {
            Cursor cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI,null,null,null,null);
            cursor.moveToFirst();

            do{
                try {
                    String name = String.valueOf(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
                    int date = cursor.getColumnIndex(CallLog.Calls.DATE);
                    int number  = cursor.getColumnIndex(CallLog.Calls.NUMBER);

                    String thisDate = cursor.getString(date);
                    String thisNumber = cursor.getString(number);

                    nameArray.add(String.valueOf(name));
                    numberArray.add(String.valueOf(thisNumber));
                    dateArray.add(String.valueOf(thisDate));
                } catch (Exception e) {
                Log.e("My App", "Error in creation");
                }
            } while (cursor.moveToNext());

            cursor.close();

//        } catch (SecurityException e) {
//
//        }


        // POPULATE XML LIST

        lv = (ListView) findViewById(R.id.recentCallsList);

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numberArray);

        lv.setAdapter(arrayAdapter);









//        private String getCallDetails() {
//
//            StringBuffer sb = new StringBuffer();
//            Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
//                    null, null, null);
//            int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
//            int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
//            int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
//            int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
//            sb.append("Call Details :");
//            while (managedCursor.moveToNext()) {
//                String phNumber = managedCursor.getString(number);
//                String callType = managedCursor.getString(type);
//                String callDate = managedCursor.getString(date);
//                Date callDayTime = new Date(Long.valueOf(callDate));
//                String callDuration = managedCursor.getString(duration);
//                String dir = null;
//                int dircode = Integer.parseInt(callType);
//                switch (dircode) {
//                    case CallLog.Calls.OUTGOING_TYPE:
//                        dir = "OUTGOING";
//                        break;
//
//                    case CallLog.Calls.INCOMING_TYPE:
//                        dir = "INCOMING";
//                        break;
//
//                    case CallLog.Calls.MISSED_TYPE:
//                        dir = "MISSED";
//                        break;
//                }
//                sb.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
//                        + dir + " \nCall Date:--- " + callDayTime
//                        + " \nCall duration in sec :--- " + callDuration);
//                sb.append("\n----------------------------------");
//            }
//            managedCursor.close();
//            return sb.toString();











    }

}