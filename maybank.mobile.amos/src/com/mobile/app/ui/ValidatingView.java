package com.mobile.app.ui;

public interface ValidatingView {

	/**
     * Registers the given validator.
     * 
     * @param validator
     * @param fieldDisplayNameForErrorMsg
     *            Localized display field name, i.e., "City" or "Postal Code".
     */
    void setValidator(ViewValidator validator,
                    String fieldDisplayNameForErrorMsg);

    /**
     * Causes the view to show or hide an error icon depending on its validity.
     */
    void flagOrUnflagValidationError();

    /**
     * Removes any error icons from the view.
     */
    void unflagValidationError();

    /**
     * Returns whether the view's value is valid.
     */
    boolean isValid();
}