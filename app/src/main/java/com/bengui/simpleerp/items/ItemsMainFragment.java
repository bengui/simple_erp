package com.bengui.simpleerp.items;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bengui.simpleerp.R;
import com.bengui.simpleerp.data.MySQLiteHelper;
import com.bengui.simpleerp.models.Item;

import java.util.ArrayList;

/**
 * Created by bengui on 10/11/14.
 */
public class ItemsMainFragment extends Fragment {

    public static final String TAG = ItemsMainFragment.class.getName();
    private ArrayList<Item> mItemsList;
    private View mView;
    private ListView mItemsListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_items_main, null);
        mItemsListView = (ListView) mView.findViewById(R.id.items_list);
        return mView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_items, menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        mItemsList = MySQLiteHelper.getInstance(getActivity()).selectAllItems();
        mItemsListView.setAdapter(new ItemsListAdapter(getActivity(), mItemsList));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_new_item) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.placeholder, new AddItemFragment(), ItemsMainFragment.TAG)
                    .addToBackStack(AddItemFragment.class.getName())
                    .commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
