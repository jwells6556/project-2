package com.justinwells.project2.RecyclerView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.justinwells.project2.R;

/**
 * Created by justinwells on 11/8/16.
 */

public class ShoppingCartViewHolder extends RecyclerView.ViewHolder {
    ImageView boxArt;
    TextView title;
    TextView genre;
    TextView price;
    ImageButton removeFromCart;
    CardView movieCard;

    public ShoppingCartViewHolder(View itemView) {
        super(itemView);

        boxArt = (ImageView) itemView.findViewById(R.id.box_art);
        title = (TextView) itemView.findViewById(R.id.title);
        genre = (TextView)  itemView.findViewById(R.id.genre);
        price = (TextView) itemView.findViewById(R.id.price);
        removeFromCart = (ImageButton) itemView.findViewById(R.id.remove_button);
        movieCard = (CardView) itemView.findViewById(R.id.movie_card);


    }
}
