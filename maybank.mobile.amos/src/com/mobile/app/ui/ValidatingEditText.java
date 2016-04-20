package com.mobile.app.ui;

import android.content.Context;
import android.widget.EditText;

public class ValidatingEditText extends EditText implements ValidatingView {
    public ValidatingEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	private ViewValidator validator;
    private String fieldDisplayNameForErrorMsg;
    
    // ...

    @Override
    public void setValidator(ViewValidator validator,
                    String fieldDisplayNameForErrorMsg) {
            this.validator = validator;
            this.fieldDisplayNameForErrorMsg = fieldDisplayNameForErrorMsg;

            // ...
    }

    @Override
    public void flagOrUnflagValidationError() {
            String msg = isValid() ? null : validator
                            .getErrorMessage(fieldDisplayNameForErrorMsg);
            setError(msg);
    }

    @Override
    public void unflagValidationError() {
            setError(null);
    }

    @Override
    public boolean isValid() {
            return validator.validate(this);
    }

    // ...
}