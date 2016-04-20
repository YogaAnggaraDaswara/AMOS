package com.mobile.app.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import maybank.mobile.amos.R;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class RegexValidator implements ViewValidator {
    protected Context context;
    protected Pattern pattern;

    public RegexValidator(Context context, String regex) {
            context = context;
            pattern = Pattern.compile(regex);
    }

    @Override
    public boolean validate(View view) {
            Matcher matcher = pattern.matcher(((TextView) view).getText());
            return matcher.matches();
    }

    @Override
    public String getErrorMessage(String caption) {
            return context.getString(R.string.validation_regex, caption,
                            pattern.toString());
    }
}
