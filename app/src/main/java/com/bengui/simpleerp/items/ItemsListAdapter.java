package com.bengui.simpleerp.items;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bengui.simpleerp.R;
import com.bengui.simpleerp.models.Item;

import java.util.ArrayList;

/**
 * Created by bengui on 12/11/14.
 */
public class ItemsListAdapter extends BaseAdapter {

    private ArrayList<Item> mItemsList;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mSelectedItemPosition = -1;

    public ItemsListAdapter(Context context, ArrayList<Item> itemsList){
        mItemsList = itemsList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public void notifyDataSetChanged() {
        mSelectedItemPosition = -1;
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemsList.size();
    }

    @Override
    public Item getItem(int position) {
        return mItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter_item_line, parent, false);
            holder.itemName = (TextView)convertView.findViewById(R.id.item_name);
            holder.itemDescription = (TextView) convertView.findViewById(R.id.item_description);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        Item item = getItem(position);
        holder.itemName.setText(item.getName());
        holder.itemDescription.setText(item.getDescription());
        holder.itemName.setTag(getItemId(position));

        return convertView;
    }

    public void removeSelectedItem() {
        if(mSelectedItemPosition != -1){
            removeItem(mSelectedItemPosition);
        }
    }

    private class ViewHolder {
        TextView itemName;
        TextView itemDescription;
    }

    public Item getSelectedItem(){
    return getItem(mSelectedItemPosition);
    }

    public int getSelectedItemPosition() {
        return mSelectedItemPosition;
    }

    public void setSelectedItemPosition(int selectedItemPosition) {
        mSelectedItemPosition = selectedItemPosition;
    }

    public void removeItem(int position){
        mItemsList.remove(position);
        notifyDataSetChanged();
    }
}
