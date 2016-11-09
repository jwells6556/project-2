package com.justinwells.project2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.justinwells.project2.RecyclerView.MovieRecyclerViewAdapter;
import com.justinwells.project2.RecyclerView.ShoppingCartRecyclerViewAdapter;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {
    RecyclerView recyclerView;
    static TextView totalPrice;
    Button checkoutButton;
    public static final int CHECK_OUT = 42;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        recyclerView = (RecyclerView) findViewById(R.id.movies_in_cart);
        totalPrice = (TextView) findViewById(R.id.total_price);
        checkoutButton = (Button) findViewById(R.id.checkout_button);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final List<Movie> moviesInCart = Cart.getShoppingCart().getMoviesInCart();

        recyclerView.setAdapter(new ShoppingCartRecyclerViewAdapter(moviesInCart));

        totalPrice.setText("Total Price: $" + Cart.getShoppingCart().getTotal()+ ".00");

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moviesInCart.size() > 0) {
                Intent intent = new Intent(view.getContext(), CheckoutActivity.class);
                startActivityForResult(intent, CHECK_OUT);
                } else {
                    final Dialog emptyCart = new Dialog(view.getContext());
                    emptyCart.setContentView(R.layout.no_items_in_cart_alert);
                    Button backButton = (Button) emptyCart.findViewById(R.id.back);
                    backButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            emptyCart.dismiss();
                        }
                    });
                    emptyCart.show();
                }


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recyclerView.getAdapter().notifyDataSetChanged();
        resetPrice(Cart.getShoppingCart().getTotal());
    }

    public static void resetPrice (int price) {
        totalPrice.setText("Total Price: $" + price + ".00");
    }
}
