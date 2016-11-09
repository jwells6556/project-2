package com.justinwells.project2.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.justinwells.project2.Cart;
import com.justinwells.project2.Movie;
import com.justinwells.project2.MovieDetail;
import com.justinwells.project2.R;
import com.justinwells.project2.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 11/7/16.
 */

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    public List <Movie>movieList = new ArrayList<>();

    public MovieRecyclerViewAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                                                    .inflate(R.layout.movie_card,parent,false);

        MovieViewHolder viewHolder = new MovieViewHolder(parentView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, final int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.genre.setText(movieList.get(position).getGenre());
        holder.price.setText(movieList.get(position).getPrice());
        holder.boxArt.setImageDrawable(movieList.get(position).getPoster(holder.boxArt.getContext()));

        holder.movieCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieDetail.class);
                intent.putExtra("title", holder.title.getText().toString());
                view.getContext().startActivity(intent);

            }
        });

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Cart.getShoppingCart().contains(movieList.get(position).getId())) {
                    Cart.getShoppingCart().removeItemById(movieList.get(position).getId());
                    //Toast.makeText(view.getContext(), "Removed from Cart", Toast.LENGTH_SHORT).show();
                    holder.addToCart.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
                } else {
                    Cart.getShoppingCart().addItem(movieList.get(position));
                    //Toast.makeText(view.getContext(), "Added to Cart!", Toast.LENGTH_SHORT).show();
                    holder.addToCart.setImageResource(R.drawable.ic_delete_black_24dp);
                }
            }
        });
    }

    @Override
    public void onViewAttachedToWindow(MovieViewHolder holder) {
        if (Cart.getShoppingCart().contains(movieList.get(holder.getAdapterPosition()).getId())) {
            holder.addToCart.setImageResource(R.drawable.ic_delete_black_24dp);
        } else {
            holder.addToCart.setImageResource(R.drawable.ic_add_shopping_cart_black_24dp);
        }


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }



    public void setBoxArt (MovieViewHolder holder, int position) {
        switch (movieList.get(position).getId()) {
            case 1:
                holder.boxArt.setImageResource(R.drawable.die_hard);
                break;
            case 2:
                holder.boxArt.setImageResource(R.drawable.die_hard_2);
                break;
            case 3:
                holder.boxArt.setImageResource(R.drawable.die_hard_with_a_vengeance);
                break;
            case 4:
                holder.boxArt.setImageResource(R.drawable.star_wars);
                break;
            case 5:
                holder.boxArt.setImageResource(R.drawable.ghostbusters);
                break;
            case 6:
                holder.boxArt.setImageResource(R.drawable.groundhog_day);
                break;
            case 7:
                holder.boxArt.setImageResource(R.drawable.batman);
                break;
            case 8:
                holder.boxArt.setImageResource(R.drawable.starship_troopers);
                break;
            case 9:
                holder.boxArt.setImageResource(R.drawable.super_troopers);
                break;
            case 10:
                holder.boxArt.setImageResource(R.drawable.idiocracy);
                break;
            case 11:
                holder.boxArt.setImageResource(R.drawable.shining);
                break;
            case 12:
                holder.boxArt.setImageResource(R.drawable.it);
                break;
            case 13:
                holder.boxArt.setImageResource(R.drawable.rocky_iv);
                break;
            case 14:
                holder.boxArt.setImageResource(R.drawable.princess_bride);
                break;
            case 15:
                holder.boxArt.setImageResource(R.drawable.gremlins);
                break;
            case 16:
                holder.boxArt.setImageResource(R.drawable.jaws);
                break;
            case 17:
                holder.boxArt.setImageResource(R.drawable.paranormal_activity);
                break;
            case 18:
                holder.boxArt.setImageResource(R.drawable.alien);
                break;
            case 19:
                holder.boxArt.setImageResource(R.drawable.young_frankenstein);
                break;
            case 20:
                holder.boxArt.setImageResource(R.drawable.scream);
                break;
            case 21:
                holder.boxArt.setImageResource(R.drawable.rosemarys_baby);
                break;
            case 22:
                holder.boxArt.setImageResource(R.drawable.poltergeist);
                break;
            case 23:
                holder.boxArt.setImageResource(R.drawable.tusk);
                break;
            case 24:
                holder.boxArt.setImageResource(R.drawable.babadook);
                break;
            case 25:
                holder.boxArt.setImageResource(R.drawable.hangover);
                break;
            case 26:
                holder.boxArt.setImageResource(R.drawable.step_brothers);
                break;
            case 27:
                holder.boxArt.setImageResource(R.drawable.top_gun);
                break;
            case 28:
                holder.boxArt.setImageResource(R.drawable.pulp_fiction);
                break;
            case 29:
                holder.boxArt.setImageResource(R.drawable.army_of_darkness);
                break;
            case 30:
                holder.boxArt.setImageResource(R.drawable.old_school);
                break;
        }
    }
}
