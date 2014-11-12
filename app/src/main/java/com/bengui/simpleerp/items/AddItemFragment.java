package com.bengui.simpleerp.items;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.ClipData;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.bengui.simpleerp.R;
import com.bengui.simpleerp.data.MySQLiteHelper;
import com.bengui.simpleerp.models.Item;

/**
 * Created by bengui on 12/11/14.
 */
public class AddItemFragment extends Fragment {

    View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ActionBar mActionBar = getActivity().getActionBar();
        mActionBar.setTitle(R.string.new_item);

        mView = inflater.inflate(R.layout.fragment_add_item, null);

        return mView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_item, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_new_item_confirm) {
            Item newItem = new Item();
            EditText newItemName = ((EditText)mView.findViewById(R.id.new_item_name));
            EditText newItemDescription = ((EditText)mView.findViewById(R.id.new_item_description));
            newItem.setName(newItemName.getText().toString());
            newItem.setDescription(newItemDescription.getText().toString());
            MySQLiteHelper.getInstance(getActivity()).saveItem(newItem);
            Toast.makeText(getActivity(), R.string.item_created_successfully, Toast.LENGTH_SHORT).show();
            getFragmentManager().popBackStack();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
