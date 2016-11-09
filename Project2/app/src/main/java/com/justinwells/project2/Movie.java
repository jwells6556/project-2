package com.justinwells.project2;

/**
 * Created by justinwells on 11/7/16.
 */

public class Movie {
    private String title, genre, price;
    private boolean inCart;
    private int id, review;

    public Movie(String title, String genre, String price, int id, int review) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.id = id;
        this.review = review;
        inCart = false;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public int getReview() {
        return review;
    }

    public void setInCart (boolean inCart) {
        this.inCart = inCart;
    }

    public boolean isInCart () {
        return inCart;
    }


}
