package com.mobile.framework.widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import sm.mobile.framework.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CalendarView extends RelativeLayout {
	
	public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE");
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d");
	public static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
	public static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMMM");
	public static final SimpleDateFormat MONTH_YEAR_FORMAT = new SimpleDateFormat("MMMM yyyy");
	
	private TextView lblDay = null;
	private TextView lblDate = null;
	private TextView lblMonthYear = null;
	
	private Date theDate;
	
	public CalendarView(Context context) {
		super(context);
		initCalenderView(context);
	}
	
	public CalendarView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initCalenderView(context);
	}
	
	public CalendarView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initCalenderView(context);
	}
	
	private void initCalenderView(Context context) {
		inflate(context, R.layout.sm_calender_view_layout, this);
		updateDate(GregorianCalendar.getInstance().getTime());
	}
	
	private void updateDate(Date date) {
		String strDay = DAY_FORMAT.format(date);
		String strDate = DATE_FORMAT.format(date);
		String strMonthYear = MONTH_YEAR_FORMAT.format(date);
		
		theDate = date;
		
		lblDay = (TextView) findViewById(R.id.lbl_sm_calendar_view_day);
		lblDate = (TextView) findViewById(R.id.lbl_sm_calendar_view_date);
		lblMonthYear = (TextView) findViewById(R.id.lbl_sm_calendar_view_month_year);
		
		if (lblDay != null) {
			lblDay.setText(strDay.toUpperCase());
		}
		if (lblDate != null) {
			lblDate.setText(strDate.toUpperCase());
		}
		if (lblMonthYear != null) {
			lblMonthYear.setText(strMonthYear.toUpperCase());
		}
	}
	
	public void setDate(Date date) {
		updateDate(date);
	}
	
	public Date getDate() {
		return theDate;
	}
}
