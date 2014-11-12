package com.bengui.simpleerp.items;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bengui.simpleerp.R;

public class ItemsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.placeholder, new ItemsMainFragment(), ItemsMainFragment.TAG)
                .commit();

    }

}
