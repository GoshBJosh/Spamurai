package org.spamurai.spamurai;


import java.lang.reflect.Method;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;

public class CheckContacts extends BroadcastReceiver{
    String incomingNumber="";
    AudioManager audioManager;
    TelephonyManager telephonyManager;
    public void onReceive(Context context, Intent intent) {
        // Get AudioManager
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // Get TelephonyManager
        telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (intent.getAction().equals("android.intent.action.PHONE_STATE"))  {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))  {
                // Get incoming number
                incomingNumber =  intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            }
        }

        if(!incomingNumber.equals("")){
            // Get an instance of ContentResolver
            ContentResolver cr=context.getContentResolver();
            // Fetch the matching number
            Cursor numbers=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,  new  String[]{ContactsContract.CommonDataKinds.Phone.CONTACT_ID,ContactsContract.CommonDataKinds.Phone.NUMBER},  ContactsContract.CommonDataKinds.Phone.NUMBER +"=?", new String[]{incomingNumber},  null);
            if(numbers.getCount()<=0){ // The incoming number is not  found in the contacts list
                // Turn on the mute
                audioManager.setStreamMute(AudioManager.STREAM_RING,  true);
                // Reject the call
                rejectCall();
                // Send the rejected message ton app
                startApp(context,incomingNumber);
            }

        }
    }



    private void startApp(Context context, String number){
        Intent intent=new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("number", "Rejected incoming number:"+number);
        context.startActivity(intent);
    }

    private void rejectCall(){


        try {

            // Get the getITelephony() method
            Class<?> classTelephony = Class.forName(telephonyManager.getClass().getName());
            Method method = classTelephony.getDeclaredMethod("getITelephony");
            // Disable access check
            method.setAccessible(true);
            // Invoke getITelephony() to get the ITelephony interface
            Object telephonyInterface = method.invoke(telephonyManager);
            // Get the endCall method from ITelephony
            Class<?> telephonyInterfaceClass =Class.forName(telephonyInterface.getClass().getName());
            Method methodEndCall = telephonyInterfaceClass.getDeclaredMethod("endCall");
            // Invoke endCall()
            methodEndCall.invoke(telephonyInterface);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}



