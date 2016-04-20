package com.mobile.app.ui;

import android.view.View;

public interface ViewValidator {
	 boolean validate(View view);
     /**
      * Returns a localized error message (even when validation has been successful).
      * @param caption the display name of the TextView (i.e., "ZIP Code")
      * @return localized error message; never null
      */
     String getErrorMessage(String caption);
}
