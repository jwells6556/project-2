package com.justinwells.project2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by justinwells on 11/7/16.
 */

public class MovieSQLiteOpenHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MOVIE_DB";
    public static final String TABLE_NAME = "movies";

    public static final String COL_ID = "ID";
    public static final String COL_TITLE = "Title";
    public static final String COL_GENRE = "Genre";
    public static final String COL_PRICE = "Price";
    public static final String COL_RATING = "Rating";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_RELEASE = "release";
    public static final String [] MOVIE_COLUMNS = {COL_ID,COL_TITLE,COL_GENRE
                                                    ,COL_PRICE, COL_RATING, COL_DESCRIPTION
                                                        ,COL_RELEASE};

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            COL_ID + " INTEGER PRIMARY KEY, " +
            COL_TITLE + " TEXT, " +
            COL_GENRE + " TEXT, " +
            COL_PRICE + " TEXT, " +
            COL_DESCRIPTION + " TEXT, " +
            COL_RELEASE + " INTEGER, " +
            COL_RATING + " INTEGER )";

    private static MovieSQLiteOpenHelper sInstance;

    public static MovieSQLiteOpenHelper getInstance (Context context) {
        if (sInstance == null) {
            sInstance = new MovieSQLiteOpenHelper(context.getApplicationContext());
        }

        return sInstance;
    }

    private MovieSQLiteOpenHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }



    public Movie getMovieByTitle (String title) {
        SQLiteDatabase db = getReadableDatabase();
        Movie movie;

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_TITLE + " = ?", // c. selections
                new String[]{title}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {

            String name = cursor.getString(cursor.getColumnIndex(COL_TITLE));
            String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
            String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
            int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
            String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
            int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));

            movie = new Movie(name, genre, price, id, rating,description,release);
            cursor.close();
        } else {
            cursor.close();
            return null;
        }

        return movie;
    }

    public List<Movie>searchMovies(String query) {
        SQLiteDatabase db = getReadableDatabase();
        List<Movie> movieList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_TITLE +  " LIKE ?", // c. selections
                new String[]{"%"+query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
                String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));

                movieList.add(new Movie(title, genre, price, id, rating,description,release));
                cursor.moveToNext();
            }
            cursor.close();
        } else {
            cursor.close();
            return null;
        }

        return movieList;
    }

    //returns list of movies with the highest ranking
    public List<Movie> getTopRated () {
        SQLiteDatabase db = getReadableDatabase();
        List<Movie> movieList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_RATING + " = ?", // c. selections
                new String[]{String.valueOf(5)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {
           while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
            String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
            String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
            int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
            String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
            int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));

            movieList.add(new Movie(title, genre, price, id, rating,description,release));
               cursor.moveToNext();
           }
            cursor.close();
        } else {
            cursor.close();
            return null;
        }

        return movieList;
    }

    //Queries database and returns list of action genre
    public List<Movie> getAction () {
        SQLiteDatabase db = getReadableDatabase();
        List<Movie> movieList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_GENRE + " = ?", // c. selections
                new String[]{"Action"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
                String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));

                movieList.add(new Movie(title, genre, price, id, rating,description,release));
                cursor.moveToNext();
            }
            cursor.close();
        } else {
            cursor.close();
            return null;
        }



        return movieList;
    }

    //Queries database and returns list of horror genre
    public List<Movie> getHorror () {
        SQLiteDatabase db = getReadableDatabase();
        List<Movie> movieList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_GENRE + " = ?", // c. selections
                new String[]{"Horror"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
                String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));

                movieList.add(new Movie(title, genre, price, id, rating,description,release));
                cursor.moveToNext();
            }
            cursor.close();
        } else {
            cursor.close();
            return null;
        }



        return movieList;
    }

    //Queries database and returns list of comedy genre
    public List<Movie> getComedy () {
        SQLiteDatabase db = getReadableDatabase();
        List<Movie> movieList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                MOVIE_COLUMNS, // b. column names
                COL_GENRE + " = ?", // c. selections
                new String[]{"Comedy"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                String genre = cursor.getString(cursor.getColumnIndex(COL_GENRE));
                String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
                int rating = cursor.getInt(cursor.getColumnIndex(COL_RATING));
                String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
                int release = cursor.getInt(cursor.getColumnIndex(COL_RELEASE));

                movieList.add(new Movie(title, genre, price, id, rating,description,release));
                cursor.moveToNext();
            }
            cursor.close();
        } else {
            cursor.close();
            return null;
        }



        return movieList;
    }



}



