package com.bengui.simpleerp.data;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bengui on 09/11/14.
 */
public class StocksTable {

    public static final String TABLE_NAME = "stocks";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ITEM_ID = "item_id";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_ITEM_ID + " INTEGER, "
            + COLUMN_QUANTITY + " INTEGER DEFAULT 0, "
            + "FOREIGN KEY (" + COLUMN_ITEM_ID + ")  REFERENCES "
            + ItemsTable.TABLE_NAME + " (" + ItemsTable.COLUMN_ID + ") );";



}
