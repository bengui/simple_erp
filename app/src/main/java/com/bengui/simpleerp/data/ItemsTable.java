package com.bengui.simpleerp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bengui.simpleerp.models.Item;

import java.util.ArrayList;

/**
 * Created by bengui on 09/11/14.
 */
public class ItemsTable{

    public static final String TABLE_NAME = "items";
    public static final String COLUMN_ID = "item_id";
    public static final String COLUMN_NAME = "item_name";
    public static final String COLUMN_DESCRIPTION = "item_description";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + "INTEGER PRIMARY KEY, "
            + COLUMN_DESCRIPTION + " TEXT, "
            + COLUMN_NAME + " VARCHAR NOT NULL);";

    public static void saveItem(Item item, SQLiteDatabase db){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, item.getName());
        values.put(COLUMN_DESCRIPTION, item.getDescription());
        db.insert(TABLE_NAME, null, values);
    }

    public static ArrayList<Item> getAllItems(SQLiteDatabase db){
        ArrayList<Item> itemsList = new ArrayList<Item>();
        Item item;
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            item = new Item();
            item.setName(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
            item.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
            itemsList.add(item);
            cursor.moveToNext();
        }
        return itemsList;
    }

}
