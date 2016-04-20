package com.mobile.app.ui;

import java.util.ArrayList;
import java.util.Collections;

import com.mobile.bo.app.dataprovider.DataProviderManager;
import com.mobile.bo.app.datatype.LovData;
import com.mobile.bo.app.datatype.MitraData;
import com.mobile.bo.app.datatype.StageData;
import com.mobile.bo.app.datatype.TabunganData;
import com.mobile.framework.widget.ISpinnerItem;

import maybank.mobile.amos.R;
import android.content.Context;
import android.widget.ArrayAdapter;

public class ListOfValueAdapter extends ArrayAdapter<ISpinnerItem> {

    private static class PleaseSelectItem implements ISpinnerItem {
        private String text = "";
        private String value = "";

        public PleaseSelectItem() {
            Context ctx = DataProviderManager.getAttachedContext();
            text = ctx.getString(R.string.str_please_select);
        }

        @Override
        public String onSpinnerGetText() {
            return text;
        }

        @Override
        public Object onSpinnerGetValue() {
            return value;
        }
    }


    public ListOfValueAdapter(Context context, ArrayList<ISpinnerItem> list) {
        super(context, android.R.layout.simple_spinner_item, list);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public static ArrayList<ISpinnerItem> createESAdapterLov(ArrayList<LovData> list) {
        Collections.sort(list);
        ArrayList<ISpinnerItem> retList = new ArrayList<ISpinnerItem>();
        retList.add(new PleaseSelectItem());

        if (list != null) {
            for (LovData pd : list) {
                retList.add(pd);
            }
        }
        return retList;
    }
    public static ArrayList<ISpinnerItem> createESAdapterLovWithCode(ArrayList<LovData> list) {
        Collections.sort(list);
        ArrayList<ISpinnerItem> retList = new ArrayList<ISpinnerItem>();
        retList.add(new PleaseSelectItem());

        if (list != null) {
            for (LovData pd : list) {
            	pd.setDESCRIPTION(pd.getCODE() + " - " + pd.getDESCRIPTION());
                retList.add(pd);
            }
        }
        return retList;
    }

    public static ArrayList<ISpinnerItem> createESAdapterTabungan(ArrayList<TabunganData> list) {
        ArrayList<ISpinnerItem> retList = new ArrayList<ISpinnerItem>();
        retList.add(new PleaseSelectItem());

        if (list != null) {
            for (TabunganData pd : list) {
                retList.add(pd);
            }
        }
        return retList;
    }

    public static ArrayList<ISpinnerItem> createESAdapterMitra(ArrayList<MitraData> list) {
        ArrayList<ISpinnerItem> retList = new ArrayList<ISpinnerItem>();
        retList.add(new PleaseSelectItem());

        if (list != null) {
            for (MitraData pd : list) {
                retList.add(pd);
            }
        }
        return retList;
    }

    public static ArrayList<ISpinnerItem> createESAdapterStage(ArrayList<StageData> list) {
        ArrayList<ISpinnerItem> retList = new ArrayList<ISpinnerItem>();
        retList.add(new PleaseSelectItem());

        if (list != null) {
            for (StageData pd : list) {
                retList.add(pd);
            }
        }
        return retList;
    }
}
