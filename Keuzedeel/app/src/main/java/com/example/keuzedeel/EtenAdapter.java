package com.example.keuzedeel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.keuzedeel.R;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by danle on 7/25/2016.
 */
public class EtenAdapter extends ArrayAdapter<Eten> {

    // Resource ID for the background color fo this list of words
    private int mColorResourceId;
    public EtenAdapter(Activity context, ArrayList<Eten> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceId = colorResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_eten, parent, false);
        }
        Eten currentWord = getItem(position);

   ImageView iconView = (ImageView) listItemView.findViewById( R.id.image );
        if(currentWord.hasImage()){
         // Set the imageview to the image resource specified in the current word
           iconView.setImageResource(currentWord.getImageResourceID());
            //Make sure the view is visible
           iconView.setVisibility( View.VISIBLE );
        } else {
           // otherwise hide the imageview (set visibility to gone)
          iconView.setVisibility(View.GONE); }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById( R.id.text_container );
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor( getContext(), mColorResourceId );
        //Set the background color of the text container View
        textContainer.setBackgroundColor( color );
        // Return the whole list item layout (containing 2 TextViews and an ImageView)so that it can be shown in the ListView
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView etenTextView = (TextView) listItemView.findViewById(R.id.etem_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        etenTextView.setText(currentWord.getEtenRestaurant());

        return listItemView;
    }


}