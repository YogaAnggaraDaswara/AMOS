package com.mobile.framework.widget;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ExSpinner extends Spinner {
	
	public static class ExSpinnerItem {
		private String itemText;
		private Object itemValue;
		private boolean combinedText = false;
		
		public ExSpinnerItem(String text, Object value) {
			itemText= text;
			itemValue = value;
		}
		
		public ExSpinnerItem(String text, Object value, boolean includeValueInText) {
			itemText= text;
			itemValue = value;
			combinedText = includeValueInText;
		}
		
		public String getItemText() {
			return itemText;
		}
		
		public Object getItemValue() {
			return itemValue;
		}
		
		@Override
		public String toString() {
			String retVal = "";
			
			if (itemText != null) {
				if (itemText.length() > 0) {
					if (combinedText) {
						retVal = itemValue + " - " + itemText;				
					} else {
						retVal = itemText;
					}
				} 
			} else if (itemValue != null) {
				if (itemValue != null) {
					retVal = itemValue.toString();
				} 				
			}
			
			if (retVal.length() == 0) {
				retVal = super.toString();
			}
			
			return retVal;
		}
	}
	
	public static class ExSpinnerAdapter extends ArrayAdapter<ExSpinnerItem> {

		public ExSpinnerAdapter(Context context, ArrayList<ExSpinnerItem> list) {
			super(context, android.R.layout.simple_spinner_item, list);
			setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		}
	}
	
	public ExSpinner(Context context) {
		super(context);
	}
	
	public ExSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ExSpinner(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public Object getSelectedListOfValue(int index) {
		ExSpinnerItem item = (ExSpinnerItem) getItemAtPosition(index);
		Object retVal = null;
		
		if (item != null) {
			retVal = item.getItemValue();
		}
		
		return retVal;
	}
	
	public Object getSelectedListOfValue() {
		ExSpinnerItem item = (ExSpinnerItem) getSelectedItem();
		Object retVal = null;
		
		if (item != null) {
			retVal = item.getItemValue();
		}
		
		return retVal;
	}
	
	public void setSelectedListOfValue(Object value) {
		int itemCount = getCount();
		for (int counter = 0; counter < itemCount; counter++) {
			ExSpinnerItem item = (ExSpinnerItem) getItemAtPosition(counter);
			if (item != null) {
				Object itemValue = item.getItemValue();
				if (itemValue != null) {
					if (itemValue.equals(value)) {
						setSelection(counter);
						break;
					}
				}
			}
		}
	}
	
	
	public int setSelectedListOfValue2(Object value) {
		int status=0;
		int itemCount = getCount();
		for (int counter = 0; counter < itemCount; counter++) {
			ExSpinnerItem item = (ExSpinnerItem) getItemAtPosition(counter);
			if (item != null) {
				Object itemValue = item.getItemValue();
				if (itemValue != null) {
					if (itemValue.equals(value)) {
						setSelection(counter);
						status=1;
						break;
					}
				}
			}
		}
		
		return status;
	}
	
	
	
	public void setListOfValue(ArrayList<ISpinnerItem> list, boolean includeValueInText) {	
		if (list != null) {
			
			ArrayList<ExSpinnerItem> retList = new ArrayList<ExSpinner.ExSpinnerItem>();
			
			for (ISpinnerItem ispn : list) {
				retList.add(new ExSpinnerItem(
						ispn.onSpinnerGetText(), 
						ispn.onSpinnerGetValue(),
						includeValueInText));
			}
			
			ExSpinnerAdapter adapter = new ExSpinnerAdapter(getContext(), retList);
			
			setAdapter(adapter);
		}
	}
	
	public void setAdapter(ExSpinnerAdapter adapter) {
		super.setAdapter(adapter);
	}
	
	public void notifyListOfValueDataChanged() {		
		if (getAdapter() != null) {
			ExSpinnerAdapter adapter = (ExSpinnerAdapter) getAdapter();
			adapter.notifyDataSetChanged();
		}
	}
}
