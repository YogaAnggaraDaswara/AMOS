package com.mobile.appraisal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;

import bii.mobile.amos.R;

public class FragmentRadioButton extends Fragment {
    RadioButton radioButton1;
    RadioButton radioButton2;
    private Context ctx = null;
    public FragmentRadioButton() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main, null);
        ctx = this.getActivity();
        super.onCreate(savedInstanceState);
        ListView lv= (ListView)view.findViewById(R.id.listview);
 
        // create the grid item mapping
        String[] from = new String[] {"rowid", "col_1", "col_2", "col_3"};
        int[] to = new int[] { R.id.item1, R.id.item2, R.id.item3, R.id.item4 };
 
        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < 10; i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("rowid", "" + i);
            map.put("col_1", "col_1_item_666666666666666666" + i);
            map.put("col_2", "col_2_item_77777777777777777777" + i);
            map.put("col_3", "col_3_item_999999999999999999999999" + i);
            fillMaps.add(map);
        }
 
        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(ctx, fillMaps, R.layout.grid_item, from, to);
        lv.setAdapter(adapter);
        return view;
    }
}
