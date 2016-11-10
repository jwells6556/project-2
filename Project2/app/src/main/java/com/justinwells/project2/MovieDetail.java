package com.justinwells.project2;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.justinwells.project2.RecyclerView.MovieViewHolder;

public class MovieDetail extends AppCompatActivity {
    TextView title, release, genre, description;
    Button addToCart;
    ImageView poster, star1, star2, star3, star4, star5;
    boolean inCart;
    Movie movie;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        String movieDetailTitle = getIntent().getStringExtra("title");
        movie = MovieSQLiteOpenHelper.getInstance(this).getMovieByTitle(movieDetailTitle);

        id = movie.getId();

        poster = (ImageView) findViewById(R.id.movie_poster_detail);
        poster.setImageDrawable(movie.getPoster(this));

        title = (TextView) findViewById(R.id.title_detail_screen);
        title.setText(movie.getTitle());

        star1 = (ImageView) findViewById(R.id.star1);
        star2 = (ImageView) findViewById(R.id.star2);
        star3 = (ImageView) findViewById(R.id.star3);
        star4 = (ImageView) findViewById(R.id.star4);
        star5 = (ImageView) findViewById(R.id.star5);

        animateStars(movie.getReview());

        release = (TextView) findViewById(R.id.release);
        release.setText(setRelease(movie));

        genre = (TextView) findViewById(R.id.genre);
        genre.setText(setGenreText(movie));

        description = (TextView) findViewById(R.id.description);
        description.setText(movie.getDescription());

        addToCart = (Button) findViewById(R.id.add_to_cart_detail);
        setButtonText();


        inCart = Cart.getShoppingCart().contains(movie.getId());

        if (inCart) {
            String text = "REMOVE FROM CART";
            addToCart.setText(text);
        }

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cart cart = Cart.getShoppingCart();


                if(cart.contains(id)) {

                    cart.removeItemById(id);

                    Toast toast =
                            Toast.makeText(getApplicationContext(), "Removed from Cart", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 300);
                    toast.show();


                    finish();

                } else {

                    cart.addItem(movie);

                    Toast toast =
                            Toast.makeText(getApplicationContext(), "Added to Cart!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 300);
                    toast.show();

                    finish();
                }

            }
        });


    }

    public void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    private String setRelease (Movie movie) {
        int release = movie.getRelease();
        return ("Released: " + release);
    }

    private String setGenreText (Movie movie) {
        String genre = movie.getGenre();
        return ("Genre: " + genre);
    }

    public void animateStars (int rating) {

        for (int i = 1; i <= rating; i++) {
            switch (i) {
                case 1: star1.setImageResource(R.drawable.ic_star_black_24dp);
                    break;
                case 2: star2.setImageResource(R.drawable.ic_star_black_24dp);
                    break;
                case 3: star3.setImageResource(R.drawable.ic_star_black_24dp);
                    break;
                case 4: star4.setImageResource(R.drawable.ic_star_black_24dp);
                    break;
                case 5: star5.setImageResource(R.drawable.ic_star_black_24dp);
                    break;
            }
        }

    }

    private void setButtonText () {
        String buttonText;
        Cart cart = Cart.getShoppingCart();

        if (cart.contains(id)){
            buttonText = "REMOVE FROM CART";
        } else {
            buttonText = "ADD TO CART";
        }

        addToCart.setText(buttonText);
    }




}
