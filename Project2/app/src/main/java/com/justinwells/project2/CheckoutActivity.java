package com.justinwells.project2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    EditText firstName, lastName, address, cardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        firstName = (EditText) findViewById(R.id.first_name);
        lastName = (EditText) findViewById(R.id.last_name);
        address = (EditText) findViewById(R.id.address);
        cardNumber = (EditText) findViewById(R.id.card_number);

        TextView total = (TextView) findViewById(R.id.checkout_total);
        total.setText(getTotal());

        Button payButton = (Button) findViewById(R.id.pay_and_finish);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean passed = true;
                String error = "Must be filled out";
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();
                String mail = address.getText().toString();
                String card = cardNumber.getText().toString();

                if (first.length() < 1) {
                    passed = false;
                    firstName.setError(error);
                }
                if (last.length() < 1) {
                    passed = false;
                    lastName.setError(error);
                }
                if (mail.length() < 1) {
                    passed = false;
                    address.setError(error);
                }
                if (card.length() < 1) {
                    passed = false;
                    cardNumber.setError(error);
                }
                if (passed) {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    Cart.getShoppingCart().emptyCart();
                    finish();
                }
            }
        });
    }

    public String getTotal () {
        return "Total Price: $" + Cart.getShoppingCart().getTotal()+ ".00";
    }
}
