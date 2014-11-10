package com.bengui.simpleerp.data;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bengui on 09/11/14.
 */
public class ItemsTable{

    public static final String TABLE_NAME = "items";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + "INTEGER PRIMARY KEY, "
            + COLUMN_NAME + "VARCHAR NOT NULL);";

}
