package org.spamurai.spamurai;

import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CallReviewAdapter extends ArrayAdapter<CallReviewItem> {

    // declaring our ArrayList of items
    private ArrayList<CallReviewItem> objects;

    /* here we must override the constructor for ArrayAdapter
    * the only variable we care about now is ArrayList<Item> objects,
    * because it is the list of objects we want to display.
    */
    public CallReviewAdapter(Context context, int textViewResourceId, ArrayList<CallReviewItem> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    /*
     * we are overriding the getView method here - this is what defines how each
     * list item will look.
     */
    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.call_item, null);
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        CallReviewItem i = objects.get(position);

        if (i != null) {

            // This is how you obtain a reference to the TextViews.
            // These TextViews are created in the XML files we defined.

            TextView tt = (TextView) v.findViewById(R.id.toptext);
            TextView ttd = (TextView) v.findViewById(R.id.toptextdata);
            TextView mt = (TextView) v.findViewById(R.id.middletext);
            TextView mtd = (TextView) v.findViewById(R.id.middletextdata);
            TextView bt = (TextView) v.findViewById(R.id.bottomtext);
            TextView btd = (TextView) v.findViewById(R.id.desctext);

            // check to see if each individual textview is null.
            // if not, assign some text!
            if (tt != null){
                tt.setText("Name: ");
            }
            if (ttd != null){
                ttd.setText(i.getName());
            }
            if (mt != null){
                mt.setText("Date: ");
            }
            if (mtd != null){
                mtd.setText(i.getDate());
            }
            if (bt != null){
                bt.setText("Number: ");
            }
            if (btd != null){
                btd.setText(i.getNumber());
            }
        }

        // the view must be returned to our activity
        return v;

    }

}
