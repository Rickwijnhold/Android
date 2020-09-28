package com.example.keuzedeel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.keuzedeel.R;

import java.util.ArrayList;

public class EtenActivity extends AppCompatActivity {
int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_eten );

        // Create a list of words

        ArrayList<Eten> words = new ArrayList<Eten>();
        words.add( new Eten("Rundergehakt", R.drawable.rundergehakt) );
        words.add( new Eten( "Paardenvlees", R.drawable.paardenvlees) );
        words.add( new Eten( "Schapenvlees", R.drawable.schapenvlees) );
        words.add( new Eten( "Varkensvlees",R.drawable.varkensvlees) );
        words.add( new Eten( "Ossenhaas",R.drawable.ossenhaas ) );
        words.add( new Eten( "Kipfilet",R.drawable.kipfilet ) );
        words.add( new Eten( "Lamsbout", R.drawable.lamsbout ) );

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        EtenAdapter adapter = new EtenAdapter( this, words, R.color.tan_background );

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById( R.id.list );

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter( adapter );
    }
    public void submitOrder(View view) {
        // Find the user's name
        EditText invoerText = (EditText) findViewById(R.id.name_field);
        String value = invoerText.getText().toString();
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, value);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " +value);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }
    private int calculatePrice(){
        int basePrice = 4;
        return quantity*basePrice;
    }

    private String createOrderSummary(int price, String value) {

        String priceMessage = "name: "+value;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $"+ price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    public void goToOrder(View view) {
        setContentView( R.layout.activity_bestellen );
        }

    public void increment(View view) {
        if (quantity == 100){
            Toast.makeText(this, "You cannot have more than 100",Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if (quantity== 1) {
            return;
        }
        quantity = quantity-1;
        displayQuantity(quantity);
    }
    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }
}