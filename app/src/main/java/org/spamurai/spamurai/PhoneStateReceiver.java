package org.spamurai.spamurai;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;


public class PhoneStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                Toast.makeText(context,"Incoming Call State",Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"Ringing State Number is -"+incomingNumber,Toast.LENGTH_SHORT).show();



                //Experimenting with retrieving contacts
                String incomingAsString = incomingNumber.toString();

                ContentResolver resolver = context.getContentResolver();
                Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

                while (cursor.moveToNext()){

                    Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", new String[]{ id }, null);

                    String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    String contactAsString = phoneNumber.replaceAll("[()\\s-]+", "");

                    if(incomingAsString == contactAsString) {
                        Toast.makeText(context, "Number matches", Toast.LENGTH_SHORT).show();
                    }
                    if(incomingAsString != contactAsString) {
                        Toast.makeText(context, "Number DOES NOT match", Toast.LENGTH_SHORT).show();

                        AudioManager am;
                        am= (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

                    }



                    while (phoneCursor.moveToNext()){



                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}

