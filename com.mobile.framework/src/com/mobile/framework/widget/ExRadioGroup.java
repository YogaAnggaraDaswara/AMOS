package com.mobile.framework.widget;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ExRadioGroup extends RadioGroup {

	private static int OFFSET_ID = 0x7F071000;
	
	public static class RadioGroupItemValue {
		private String itemText;
		private Object itemValue;
		
		public RadioGroupItemValue(String text, Object value) {
			itemText= text;
			itemValue = value;
		}
		
		public String getItemText() {
			return itemText;
		}
		
		public Object getItemValue() {
			return itemValue;
		}
	}
	
	public ExRadioGroup(Context context) {
		super(context);
	}
	
	public ExRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setListOfText(ArrayList<RadioGroupItemValue> listOfText) {
		if (listOfText != null) {
			removeAllViews();
			listOfText.clear();
			for (int counter = 0; counter < listOfText.size(); counter++) {
				RadioButton rb = new RadioButton(getContext());
				RadioGroupItemValue item = listOfText.get(counter);
				rb.setId(OFFSET_ID + counter);
				rb.setText(item.getItemText());
				rb.setTag(item.itemValue);
				addView(rb);
			}
		}
	}
	
	public void setSelectedItemValue(Object value) {
		int numOfChild = getChildCount();
		for (int counter = 0; counter < numOfChild; counter++) {
			View v = getChildAt(counter);
			if (v != null) {
				Object tValue = v.getTag();
				if (tValue != null) {
					if (tValue.equals(value)) {
						check(v.getId());
					}
				}
			}
		}
	}
	
	public Object getSelectedItemValue() {
		Object retVal = null;
		int itemId = getCheckedRadioButtonId();
		if (itemId != View.NO_ID) {
			View v = findViewById(itemId);
			retVal = v.getTag();
		}
		return retVal;
	}
}
