package com.bengui.simpleerp.data;

/**
 * Created by bengui on 10/11/14.
 */
public class ClientsTable {

    public static final String TABLE_NAME = "clients";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_NOTES = "notes";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_NAME + " VARCHAR NOT NULL, "
                    + COLUMN_ADDRESS + " VARCHAR, "
                    + COLUMN_EMAIL + " VARCHAR, "
                    + COLUMN_PHONE + " VARCHAR, "
                    + COLUMN_NOTES + " TEXT);";


}
