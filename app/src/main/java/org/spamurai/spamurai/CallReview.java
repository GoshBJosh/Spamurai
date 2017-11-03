package org.spamurai.spamurai;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CallReview extends AppCompatActivity {
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_review);



            lv = (ListView) findViewById(R.id.recentCallsList);

        ArrayList<JSONObject> contacts = new ArrayList<>();

        public void addContacts(){

            //to store name-number pair
            JSONObject obj = new JSONObject();

            try {
                Uri allCalls = Uri.parse("content://call_log/calls");
                Cursor c = managedQuery(allCalls, null, null, null, null);

                while (c.moveToNext()) {
                    String phoneNumber = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));



                    Log.e("Contact list with name & numbers", " ");
                }
                c.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }// This is the array adapter, it takes the context of the activity as a
            // first parameter, the type of list view as a second parameter and your
            // array as a third parameter.
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    JSONArray);

            lv.setAdapter(arrayAdapter);
    }

}