package com.mobile.framework.widget;

import java.util.Date;

import com.mobile.framework.animation.AnimationFactory;
import com.mobile.framework.animation.AnimationFactory.FlipDirection;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ViewFlipper;
import sm.mobile.framework.R;

public class AnimatedCalenderView extends FrameLayout {
	
	public interface OnDateChangedListener {
		public abstract void onDateChanged(AnimatedCalenderView view); 
	}
	
	private CalendarView firstCalenderView = null;
	private CalendarView secondCalenderView = null;
	private ViewFlipper viewAnimator = null;
	private Date theDate;
	
	private OnDateChangedListener dateChangedListener = null;
	
	public AnimatedCalenderView(Context context) {
		super(context);
		initAnimatedCalenderView(context, null);
	}
	
	public AnimatedCalenderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initAnimatedCalenderView(context, null);
	}
	
	public AnimatedCalenderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initAnimatedCalenderView(context, attrs);
	}
	
	private void initAnimatedCalenderView(Context context, AttributeSet attrs) {
		inflate(context, R.layout.sm_animated_calendar_view_layout, this);
		viewAnimator = (ViewFlipper) findViewById(R.id.calendar_view_flipper);
		
		firstCalenderView = (CalendarView) findViewById(R.id.ctrl_calender_1);
		secondCalenderView = (CalendarView) findViewById(R.id.ctrl_calender_2);
		
		theDate = firstCalenderView.getDate();
	}
	
	private void updateDate(Date date) {
		CalendarView currentView = (CalendarView) viewAnimator.getCurrentView();
		theDate = date;
			if (firstCalenderView.equals(currentView)) {
				secondCalenderView.setDate(date);
				if (!isInEditMode()) {
					AnimationFactory.flipTransition(viewAnimator, FlipDirection.LEFT_RIGHT);
				}
			} else {
				firstCalenderView.setDate(date);
				if (!isInEditMode()) {
					AnimationFactory.flipTransition(viewAnimator, FlipDirection.RIGHT_LEFT);
				}
			}
	}
	
	public boolean isCalenderFlipping() {
		return viewAnimator.isFlipping();
	}
	
	public void setDate(Date date) {
		updateDate(date);
		post(new Runnable() {
			@Override
			public void run() {
				if (dateChangedListener != null) {
					dateChangedListener.onDateChanged(AnimatedCalenderView.this);
				}
			}
		});
	}
	
	public Date getDate(){
		return theDate;
	}
	
	public void setDateChangedListener(OnDateChangedListener listener) {
		dateChangedListener = listener;
	}

}
