package com.justinwells.project2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 11/7/16.
 */

public class Cart {
    private List<Movie> moviesInCart;
    private static Cart shoppingCart;
    int total = 0;

    private Cart () {
        moviesInCart = new ArrayList<>();
    }

    public static Cart getShoppingCart () {
        if (shoppingCart == null) {
            shoppingCart = new Cart();
        }
        return shoppingCart;
    }

    public void addItem (Movie movie) {
        moviesInCart.add(movie);
    }

    public void removeItem (int position) {
        moviesInCart.remove(position);
    }

    public void removeItemById (int id) {
        for (int i = 0; i < moviesInCart.size(); i++) {
            if (moviesInCart.get(i).getId() == id) {
                moviesInCart.remove(i);
            }
        }
    }

    public void emptyCart () {

        for (int i = moviesInCart.size()-1; i > -1; i--) {
            moviesInCart.remove(i);
        }

    }

    public boolean contains (int id) {
        for (int i = 0; i < moviesInCart.size(); i++) {

            if (moviesInCart.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Movie> getMoviesInCart () {
        return moviesInCart;
    }

    public int getTotal () {
        total = 0;
        for (int i = 0; i < moviesInCart.size(); i++) {
            String price = moviesInCart.get(i).getPrice().replace("$","");
            int x = Integer.parseInt(price.substring(0,2));
            total += x;
        }

        return total;

    }

}
