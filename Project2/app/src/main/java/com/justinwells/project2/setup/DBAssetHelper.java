package com.justinwells.project2.setup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by justinwells on 11/7/16.
 */

public class DBAssetHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "MOVIE_DB";
    private static final int DATABASE_VERSION = 1;

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
