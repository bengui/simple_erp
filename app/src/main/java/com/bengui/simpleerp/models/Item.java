package com.bengui.simpleerp.models;

/**
 * Created by bengui on 12/11/14.
 */
public class Item {
    private int mId;

    private String mName;
    private String mDescription;


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
