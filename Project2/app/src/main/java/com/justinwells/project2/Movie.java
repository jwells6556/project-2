package com.justinwells.project2;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by justinwells on 11/7/16.
 */

public class Movie {
    private String title, genre, price, description;
    private boolean inCart;
    private int id, review, release;

    public Movie(String title, String genre, String price, int id, int review, String description,
                    int release) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.id = id;
        this.review = review;
        this.description = description;
        this.release = release;
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


    public String getDescription() {
        return description;
    }

    public int getRelease() {
        return release;
    }

    public Drawable getPoster (Context context) {
        switch (id) {
            case 1:
                return context.getResources().getDrawable(R.drawable.die_hard);
            case 2:
                return context.getResources().getDrawable(R.drawable.die_hard_2);
            case 3:
                return context.getResources().getDrawable(R.drawable.die_hard_with_a_vengeance);
            case 4:
                return context.getResources().getDrawable(R.drawable.star_wars);
            case 5:
                return context.getResources().getDrawable(R.drawable.ghostbusters);
            case 6:
                return context.getResources().getDrawable(R.drawable.groundhog_day);
            case 7:
                return context.getResources().getDrawable(R.drawable.batman);
            case 8:
                return context.getResources().getDrawable(R.drawable.starship_troopers);
            case 9:
                return context.getResources().getDrawable(R.drawable.super_troopers);
            case 10:
                return context.getResources().getDrawable(R.drawable.idiocracy);
            case 11:
                return context.getResources().getDrawable(R.drawable.shining);
            case 12:
                return context.getResources().getDrawable(R.drawable.it);
            case 13:
                return context.getResources().getDrawable(R.drawable.rocky_iv);
            case 14:
                return context.getResources().getDrawable(R.drawable.princess_bride);
            case 15:
                return context.getResources().getDrawable(R.drawable.gremlins);
            case 16:
                return context.getResources().getDrawable(R.drawable.jaws);
            case 17:
                return context.getResources().getDrawable(R.drawable.paranormal_activity);
            case 18:
                return context.getResources().getDrawable(R.drawable.alien);
            case 19:
                return context.getResources().getDrawable(R.drawable.young_frankenstein);
            case 20:
                return context.getResources().getDrawable(R.drawable.scream);
            case 21:
                return context.getResources().getDrawable(R.drawable.rosemarys_baby);
            case 22:
                return context.getResources().getDrawable(R.drawable.poltergeist);
            case 23:
                return context.getResources().getDrawable(R.drawable.tusk);
            case 24:
                return context.getResources().getDrawable(R.drawable.babadook);
            case 25:
                return context.getResources().getDrawable(R.drawable.hangover);
            case 26:
                return context.getResources().getDrawable(R.drawable.step_brothers);
            case 27:
                return context.getResources().getDrawable(R.drawable.top_gun);
            case 28:
                return context.getResources().getDrawable(R.drawable.pulp_fiction);
            case 29:
                return context.getResources().getDrawable(R.drawable.army_of_darkness);
            case 30:
                return context.getResources().getDrawable(R.drawable.old_school);
            default:
                return context.getResources().getDrawable(R.drawable.batman);
        }
    }


}
