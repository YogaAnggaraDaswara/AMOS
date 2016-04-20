package com.mobile.framework.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import sm.mobile.framework.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class CalendarDialog extends Dialog {
	
	public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("EEEE");
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d");
	public static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat("yyyy");
	public static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("MMMM");
	public static final SimpleDateFormat MONTH_YEAR_FORMAT = new SimpleDateFormat("MMMM yyyy");
	
	private static final int NUMBER_OF_WEEK = 6;
	private static final int NUMBER_OF_DAY_IN_WEEK = 7;
	
	private TextView[][] lblDates = new TextView[NUMBER_OF_WEEK][NUMBER_OF_DAY_IN_WEEK];
	private TextView lblMonth = null;
	private TextView lblYear = null;
	
	private Date todayDate = null;
	private Date selectedDate = null;
	
	public CalendarDialog(Context context) {
		super(context, R.style.SM_Style_Dialog_NoTitleBar);
		
		super.setContentView(R.layout.sm_calender_dialog_layout);
		
		initCalenderView();
		initCalenderData();
		
	}
	
	private void initCalenderView() {
		
		lblMonth = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_month);
		lblYear = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_year);
		
		// Minggu
		lblDates[0][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_6);
		// Senin
		lblDates[0][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_0);
		lblDates[0][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_1);
		lblDates[0][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_2);
		lblDates[0][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_3);
		lblDates[0][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_4);
		lblDates[0][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_0_5);
		
		// Minggu
		lblDates[1][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_6);
		// Senin
		lblDates[1][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_0);
		lblDates[1][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_1);
		lblDates[1][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_2);
		lblDates[1][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_3);
		lblDates[1][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_4);
		lblDates[1][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_1_5);
		
		// Minggu
		lblDates[2][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_6);
		// Senin
		lblDates[2][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_0);
		lblDates[2][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_1);
		lblDates[2][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_2);
		lblDates[2][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_3);
		lblDates[2][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_4);
		lblDates[2][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_2_5);
		
		// Minggu
		lblDates[3][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_6);		
		// Senin
		lblDates[3][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_0);
		lblDates[3][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_1);
		lblDates[3][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_2);
		lblDates[3][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_3);
		lblDates[3][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_4);
		lblDates[3][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_3_5);
		
		// Minggu
		lblDates[4][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_6);		
		// Senin
		lblDates[4][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_0);
		lblDates[4][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_1);
		lblDates[4][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_2);
		lblDates[4][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_3);
		lblDates[4][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_4);
		lblDates[4][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_4_5);
		
		// Minggu
		lblDates[5][0] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_6);
		// Senin
		lblDates[5][1] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_0);
		lblDates[5][2] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_1);
		lblDates[5][3] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_2);
		lblDates[5][4] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_3);
		lblDates[5][5] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_4);
		lblDates[5][6] = (TextView) findViewById(R.id.lbl_sm_calendar_dialog_date_5_5);
	}
	
	private void initCalenderData() {
		
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();		
		TextView lblCurrentDate = null;
		
		todayDate = calendar.getTime();
		selectedDate = todayDate;
		
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		
		int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
		int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int currentWeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH) - 1;
		
		lblMonth.setText(MONTH_FORMAT.format(calendar.getTime()));
		lblYear.setText(YEAR_FORMAT.format(calendar.getTime()));
		
		// iterate through number of current month
		for (int counter = 0; counter < maxDayOfMonth; counter++) {
			
			calendar.set(Calendar.DAY_OF_MONTH, counter + 1);
			
			currentDate = calendar.get(Calendar.DAY_OF_MONTH);
			currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
			currentWeekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH) - 1;
			
			// set date value
			lblCurrentDate = lblDates[currentWeekOfMonth][currentDayOfWeek];
			lblCurrentDate.setText(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
			lblCurrentDate.setTag(calendar.getTime());
			
			if (currentDate < todayDate.getDate()) {
				lblCurrentDate.setTextColor(R.color.lbl_sm_calendar_dialog_date_disable);
			} else {
				if (currentDate == todayDate.getDate()) {
					lblCurrentDate.setTypeface(Typeface.DEFAULT_BOLD);
				} 
				lblCurrentDate.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						TextView lblView = (TextView) v;
						selectedDate = (Date) lblView.getTag();
						CalendarDialog.this.dismiss();
					}
				});
			}
		}
	}
	
	public Date getTodayDate() {
		return todayDate;
	}
	
	public Date getSelectedDate() {
		return selectedDate;
		
	}
}
