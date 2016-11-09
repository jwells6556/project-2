package com.justinwells.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    TextView title;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        int id = getIntent().getIntExtra("id", -1);
        final Movie movie = MovieSQLiteOpenHelper.getInstance(this).getMovie(id);

        title = (TextView) findViewById(R.id.title_detail_screen);
        title.setText(movie.getTitle());

        addToCart = (Button) findViewById(R.id.add_to_cart_detail);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart.getShoppingCart().addItem(movie);
                Toast.makeText(view.getContext(), "Added to Cart!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
