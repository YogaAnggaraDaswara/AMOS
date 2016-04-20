package com.mobile.app.ui;

import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

public class DatePickerManager extends DatePickerDialog {
    int year, month, day;
    final Calendar calendar;
    Date date;

    public DatePickerManager(Context context, DatePickerDialog.OnDateSetListener callBack, int _year, int _month, int _day) {
        super(context, callBack, _year, _month, _day);
        this.year = _year;
        this.month = _month;
        this.day = _day;
        date = new Date(year, _month, _day);
        calendar = Calendar.getInstance();
    }

    public void onDateChanged(DatePicker datepicker, int _year, int _month, int _day) {
        this.year = _year;
        this.month = _month;
        this.day = _day;
        super.onDateChanged(datepicker, this.year, month, day);
    }
}
