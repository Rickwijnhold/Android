package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printToLogs(View view){
        // Find first menu item TextView and print the text to the logs
        TextView textview = (TextView) findViewById(R.id.menu_item_1);
        String menuItem1 = textview.getText().toString();
        Log.v("MainActivity", menuItem1);
        // Find second menu item TextView and print the text to the logs
        TextView textview2 = (TextView) findViewById(R.id.menu_item_2);
        String menuItem2 = textview2.getText().toString();
        Log.v("MainActivity", menuItem2);
        // Find third menu item TextView and print the text to the logs
        TextView textview3 = (TextView) findViewById(R.id.menu_item_3);
        String menuItem3 = textview3.getText().toString();
        Log.v("MainActivity", menuItem3);

    }
}