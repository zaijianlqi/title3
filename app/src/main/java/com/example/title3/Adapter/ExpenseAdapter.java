package com.example.title3.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.title3.Expense;
import com.example.title3.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9.
 */

public class ExpenseAdapter extends ArrayAdapter<Expense>{
    private int resourceId;
    public ExpenseAdapter(Context context, int textViewResourceId, List<Expense> object)
    {
        super(context,textViewResourceId,object);
        resourceId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Expense expense=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView id=(TextView) view.findViewById(R.id.id_item);
        id.setText(Integer.toString(expense.getId()));
        TextView souce=(TextView) view.findViewById(R.id.souce_item);
        souce.setText(expense.getSource());
        TextView number=(TextView) view.findViewById(R.id.number_item);
       number.setText(Integer.toString(expense.getNumber()));
        TextView time=(TextView) view.findViewById(R.id.time_item);
        time.setText(expense.getTime());
        return view;
    }
}
