package com.bengui.simpleerp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bengui.simpleerp.models.Item;

import java.util.ArrayList;

/**
 * Created by bengui on 09/11/14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TAG = MySQLiteHelper.class.getName();
    private static final String DATABASE_NAME = "simple_erp_db";
    private static final int DATABASE_VERSION = 1;
    private static MySQLiteHelper myInstance;


    private MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static MySQLiteHelper getInstance(Context context){
        if(myInstance == null){
            myInstance = new MySQLiteHelper(context);
        }
        return myInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Creating DB...");

        db.execSQL(ItemsTable.CREATE_TABLE);
        db.execSQL(ClientsTable.CREATE_TABLE);
        db.execSQL(BuysTable.CREATE_TABLE);
        db.execSQL(SellsTable.CREATE_TABLE);
        db.execSQL(BuysLinesTable.CREATE_TABLE);
        db.execSQL(SellsLinesTable.CREATE_TABLE);
        db.execSQL(StocksTable.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Item> selectAllItems(){
        return ItemsTable.getAllItems(getReadableDatabase());
    }

    public void saveItem(Item item){
        ItemsTable.saveItem(item, getWritableDatabase());
    }
}
