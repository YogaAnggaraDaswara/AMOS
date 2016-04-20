package com.mobile.framework.data;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ExListItemAdapter<DATATYPE, ITEMHOLDER extends ExBaseListItemHolder> extends BaseAdapter{
	
	public interface OnListItemListener {
		public void onItemSelected(int position);
		public void onItemDeleted(int position);
	}
	
	private List<DATATYPE> emptyList = new ArrayList<DATATYPE>();
	private List<DATATYPE> listItem = emptyList;
	private LayoutInflater objInflater = null;
	
	public ExListItemAdapter(Context ctx) {
		objInflater = LayoutInflater.from(ctx);
	}
	
	public void setExListData(List<DATATYPE> listData) {
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
		DATATYPE itemData = (DATATYPE) getItem(position);
		return onGetItemId(itemData);
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ExBaseListItemHolder instance = null;
		
		@SuppressWarnings("unchecked")
		DATATYPE itemData = (DATATYPE) getItem(position);
		
		View retView = null;
		
		if (convertView == null) {
			ITEMHOLDER itemHolder = onCreateItemHolder();
			retView = objInflater.inflate(
					itemHolder.getItemLayoutResourceId(), 
					parent, 
					false);
			
//			itemHolder.initListItem(retView);
//			itemHolder.updateListItem(position, itemData);
			
			onInitItemHolder(itemHolder, retView);
			onUpdateListItem(itemHolder, position, itemData);
			
			retView.setTag(itemHolder);
		} else {
			retView = convertView;
			
			@SuppressWarnings("unchecked")
			ITEMHOLDER itemHolder = (ITEMHOLDER) retView.getTag();
			
//			itemHolder.updateListItem(position, itemData);
			onUpdateListItem(itemHolder, position, itemData);
		}
		
		return retView;
	}
	
	public abstract ITEMHOLDER onCreateItemHolder();
	public abstract void onInitItemHolder(ITEMHOLDER holder, View view);
	public abstract long onGetItemId(DATATYPE itemData);
	public abstract void onUpdateListItem(ITEMHOLDER itemHolder, int position, DATATYPE itemData);
	
}
