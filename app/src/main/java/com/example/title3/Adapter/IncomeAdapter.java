package com.example.title3.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.title3.Income;
import com.example.title3.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9.
 */

public class IncomeAdapter extends ArrayAdapter<Income>{
    private int resourceId;
    public IncomeAdapter(Context context, int textViewResourceId, List<Income> object)
    {
        super(context,textViewResourceId,object);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Income income=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView id=(TextView) view.findViewById(R.id.id_item);
        id.setText(Integer.toString(income.getId()));
        TextView souce=(TextView) view.findViewById(R.id.souce_item);
        souce.setText(income.getSource());
        TextView number=(TextView) view.findViewById(R.id.number_item);
       number.setText(Integer.toString(income.getNumber()));
        TextView time=(TextView) view.findViewById(R.id.time_item);
        time.setText(income.getTime());
        return view;
    }
}
