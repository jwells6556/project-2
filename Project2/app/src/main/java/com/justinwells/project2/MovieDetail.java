package com.justinwells.project2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieDetail extends AppCompatActivity {
    TextView title, release, genre, description;
    Button addToCart;
    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        String movieDetailTitle = getIntent().getStringExtra("title");
        final Movie movie = MovieSQLiteOpenHelper.getInstance(this).getMovieByTitle(movieDetailTitle);

        poster = (ImageView) findViewById(R.id.movie_poster_detail);
        poster.setImageDrawable(movie.getPoster(this));

        title = (TextView) findViewById(R.id.title_detail_screen);
        title.setText(movie.getTitle());

        release = (TextView) findViewById(R.id.release);
        release.setText(setRelease(movie));

        genre = (TextView) findViewById(R.id.genre);
        genre.setText(setGenreText(movie));

        description = (TextView) findViewById(R.id.description);
        description.setText(movie.getDescription());

        addToCart = (Button) findViewById(R.id.add_to_cart_detail);

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart.getShoppingCart().addItem(movie);

                Toast toast =
                        Toast.makeText(getApplicationContext(), "Added to Cart!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 300);
                toast.show();
            }
        });


    }



    private String setRelease (Movie movie) {
        int release = movie.getRelease();
        return ("Released: " + release);
    }

    private String setGenreText (Movie movie) {
        String genre = movie.getGenre();
        return ("Genre: " + genre);
    }


}
