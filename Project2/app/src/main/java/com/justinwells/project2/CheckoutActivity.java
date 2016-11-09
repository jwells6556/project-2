package com.justinwells.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView total = (TextView) findViewById(R.id.checkout_total);
        total.setText(getTotal());

        Button payButton = (Button) findViewById(R.id.pay_and_finish);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                Cart.getShoppingCart().emptyCart();
                finish();
            }
        });
    }

    public String getTotal () {
        return "Total Price: $" + Cart.getShoppingCart().getTotal()+ ".00";
    }
}
