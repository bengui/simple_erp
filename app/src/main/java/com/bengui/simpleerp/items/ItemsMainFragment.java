package com.bengui.simpleerp.items;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bengui.simpleerp.R;
import com.bengui.simpleerp.data.MySQLiteHelper;
import com.bengui.simpleerp.models.Item;

import java.util.ArrayList;

/**
 * Created by bengui on 10/11/14.
 */
public class ItemsMainFragment extends Fragment{

    public static final String TAG = ItemsMainFragment.class.getName();
    private View mView;
    private ListView mItemsListView;
    private ActionMode mActionMode;
    private ItemsListAdapter mItemsListAdapter;

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
        ArrayList<Item> itemsList = MySQLiteHelper.getInstance(getActivity()).selectAllItems();
        mItemsListAdapter = new ItemsListAdapter(getActivity(), itemsList);
        mItemsListView.setAdapter(mItemsListAdapter);
        mItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mActionMode != null){
                    mActionMode.finish();
                }
            }
        });
        mItemsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if(mActionMode != null){
                    return false;
                }

                mActionMode = getActivity().startActionMode(mActionModeCallback);
                view.setSelected(true);
                mItemsListAdapter.setSelectedItemPosition(position);
                return true;
            }
        });

        return mView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.items_list, menu);
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
    }(or feeds)


    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.items_list_action_mode, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_edit:
                    editSelectedItem();
                    mode.finish();
                    return true;
                case R.id.action_delete:
                    deleteSelectedItem();
                    mode.finish();
                    return true;
                default:
                    return false;
            }

        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
            mItemsListView.clearChoices();
            mItemsListAdapter.notifyDataSetChanged();
        }
    };

    private void deleteSelectedItem() {
        Item item = mItemsListAdapter.getSelectedItem();
        if(item != null){
            //TODO Validate if the item doesn't have any sales or buys
            MySQLiteHelper.getInstance(getActivity()).deleteItem(item.getId());
            mItemsListAdapter.removeSelectedItem();
        }
    }

    private void editSelectedItem() {
        Item item = mItemsListAdapter.getSelectedItem();
        if(item != null){
            Toast.makeText(getActivity(), mItemsListAdapter.getSelectedItem().getName(),Toast.LENGTH_SHORT).show();
        }
    }


}
