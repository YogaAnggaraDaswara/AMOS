package com.mobile.app.ui;

import maybank.mobile.amos.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListItemWithDeleteButton {
    private TextView lblItemText;
    private TextView lblItemDesc;
    private ImageView imgDeleteItem;

    public void initOutletListItem(View v) {
        lblItemText = (TextView) v.findViewById(R.id.list_item_lbl_1);
        lblItemDesc = (TextView) v.findViewById(R.id.list_item_lbl_2);
        imgDeleteItem = (ImageView) v.findViewById(R.id.list_img_delete);
    }

    public TextView getLblItemText() {
        return lblItemText;
    }

    public TextView getLblItemDesc() {
        return lblItemDesc;
    }

    public ImageView getImgDeleteItem() {
        return imgDeleteItem;
    }
}
