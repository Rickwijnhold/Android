package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void increment(View view) {
        if (quantity == 100){
            Toast.makeText(this, "You cannot have more than 100 coffees",Toast.LENGTH_LONG).show();
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
    public void submitOrder(View view) {
        // Find the user's name
        EditText invoerText = (EditText) findViewById(R.id.name_field);
        String value = invoerText.getText().toString();
        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        // Figure out if the user wants chocolate topping
        CheckBox chocolateExtra = (CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate = chocolateExtra.isChecked();
        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(price,hasWhippedCream, hasChocolate, value);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " +value);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) !=null) {
            startActivity(intent);
        }
    }

//    Calculates the price of the order

    // @addWhippedCream is whether or not the user wants whipped cream topping
    // addChocolate is whether or not the user wants chocolate topping
    // return total price
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }
        if (addChocolate) {
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }
    private String createOrderSummary(int price, boolean whippedCream, boolean extraChocolate, String value) {

        String priceMessage = "name: "+value;
        priceMessage += "\nHas whipped cream: "+ whippedCream;
        priceMessage += "\nHas Chocolate: "+ extraChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $"+ price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }
    /**
     * Calculates the price of the order.
     *
     */


    private void displayQuantity(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }


}