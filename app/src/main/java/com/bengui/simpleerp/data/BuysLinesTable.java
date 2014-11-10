package com.bengui.simpleerp.data;

/**
 * Created by bengui on 09/11/14.
 */
public class BuysLinesTable {

    public static final String TABLE_NAME = "buys_lines";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ITEM_ID = "item_id";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_ITEM_PRICE= "item_price";
    public static final String COLUMN_BUY_ID= "buy_id";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_ITEM_ID + " INTEGER, "
                    + COLUMN_QUANTITY + " INTEGER, "
                    + COLUMN_ITEM_PRICE + " REAL, "
                    + COLUMN_BUY_ID + " INTEGER,"
                    + " FOREIGN KEY (" + COLUMN_BUY_ID + ") REFERENCES "
                    + BuysTable.TABLE_NAME + " (" + BuysTable.COLUMN_ID + "));";

}
