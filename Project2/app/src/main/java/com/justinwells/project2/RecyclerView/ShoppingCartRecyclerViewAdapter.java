package com.justinwells.project2.RecyclerView;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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
 * Created by justinwells on 11/8/16.
 */

public class ShoppingCartRecyclerViewAdapter extends RecyclerView.Adapter<ShoppingCartViewHolder> {
    List<Movie> movieList = new ArrayList<>();

    public ShoppingCartRecyclerViewAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_cart_item_card,parent,false);

        ShoppingCartViewHolder viewHolder = new ShoppingCartViewHolder(parentView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder holder, final int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.genre.setText(movieList.get(position).getGenre());
        holder.price.setText(movieList.get(position).getPrice());
        holder.boxArt.setImageDrawable(movieList.get(position).getPoster(holder.boxArt.getContext()));


        holder.removeFromCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart cart = Cart.getShoppingCart();
                cart.removeItem(position);
                notifyDataSetChanged();
                ShoppingCart.resetPrice(cart.getTotal());

            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }




}

