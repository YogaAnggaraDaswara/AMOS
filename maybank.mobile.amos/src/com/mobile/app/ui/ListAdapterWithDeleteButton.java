package com.mobile.app.ui;

import java.util.ArrayList;
import java.util.List;

import maybank.mobile.amos.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ListAdapterWithDeleteButton<T> extends BaseAdapter {
    public static interface OnListItemListener {
        public void onItemSelected(int position);

        public void onItemDeleted(int position);
    }

    private List<T> emptyList = new ArrayList<T>();
    private List<T> listItem = emptyList;
    LayoutInflater objInflater = null;

    public ListAdapterWithDeleteButton(Context ctx) {
        objInflater = LayoutInflater.from(ctx);
    }

    public void setOutletData(List<T> listData) {
        if (listData != null) {
            listItem = listData;
        } else {
            listItem = emptyList;
        }
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        @SuppressWarnings("unchecked")
        T itemData = (T) getItem(position);
        return onGetItemId(itemData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemWithDeleteButton itemHolder = null;
        @SuppressWarnings("unchecked")
        T itemData = (T) getItem(position);
        View retView = null;

        if (convertView == null) {
            retView = objInflater.inflate(R.layout.list_item_with_delete_button_layout, parent, false);
            itemHolder = new ListItemWithDeleteButton();
            itemHolder.initOutletListItem(retView);
            retView.setTag(itemHolder);
        } else {
            retView = convertView;
            itemHolder = (ListItemWithDeleteButton) retView.getTag();
        }
        onUpdateListItem(itemHolder, position, itemData);
        return retView;
    }

    public abstract long onGetItemId(T itemData);

    public abstract void onUpdateListItem(ListItemWithDeleteButton itemHolder, int position, T itemData);

}