package com.bengui.simpleerp.data;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bengui on 09/11/14.
 */
public class BuysTable {

    public static final String TABLE_NAME = "buys";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE= "date";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_DATE + " INTEGER );";

}
