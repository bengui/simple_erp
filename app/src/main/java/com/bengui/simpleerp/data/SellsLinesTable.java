package com.bengui.simpleerp.data;

/**
 * Created by bengui on 10/11/14.
 */
public class SellsLinesTable {

    public static final String TABLE_NAME = "sells_lines";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ITEM_ID = "item_id";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_ITEM_PRICE = "item_price";
    public static final String COLUMN_SELL_ID = "sell_id";
    public static final String COLUMN_CLIENT_ID = "client_id";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_ITEM_ID + " INTEGER, "
                    + COLUMN_QUANTITY + " INTEGER, "
                    + COLUMN_ITEM_PRICE + " REAL, "
                    + COLUMN_SELL_ID + " INTEGER,"
                    + COLUMN_CLIENT_ID + " INTEGER,"
                    + " FOREIGN KEY (" + COLUMN_SELL_ID + ") REFERENCES "
                    + SellsTable.TABLE_NAME + " (" + SellsTable.COLUMN_ID + "), "
                    + " FOREIGN KEY (" + COLUMN_CLIENT_ID + ") REFERENCES "
                    + ClientsTable.TABLE_NAME + " (" + ClientsTable.COLUMN_ID + "));";
}
