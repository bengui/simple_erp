package com.bengui.simpleerp.data;

/**
 * Created by bengui on 10/11/14.
 */
public class SellsTable {


    public static final String TABLE_NAME = "sells";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE= "date";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_DATE + " INTEGER );";

}
