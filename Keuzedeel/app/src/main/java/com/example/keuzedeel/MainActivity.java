package com.example.keuzedeel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView( R.layout.activity_main );

        // Find the View that shows the eten category
        TextView eten = (TextView) findViewById( R.id.eten );
        TextView info = (TextView) findViewById( R.id.info );

        // Set a click listener on that View
        eten.setOnClickListener( new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent etenIntent = new Intent( MainActivity.this, EtenActivity.class );

                // Start the new activity
                startActivity( etenIntent );
            }
        } );
        info.setOnClickListener( new View.OnClickListener() {

            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent infoIntent = new Intent( MainActivity.this, InformatiePage.class );

                // Start the new activity
                startActivity( infoIntent );
            }
        } );
    }
}