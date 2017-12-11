package com.example.title3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.title3.ActivityCollector;
import com.example.title3.Adapter.ExpenseAdapter;
import com.example.title3.Adapter.IncomeAdapter;
import com.example.title3.Expense;
import com.example.title3.Income;
import com.example.title3.R;

import org.litepal.crud.DataSupport;

import java.util.List;

public class ShowData extends AppCompatActivity {

    private List<Income> incomes= DataSupport.findAll(Income.class);
    private List<Expense> expenses=DataSupport.findAll(Expense.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ActivityCollector.addActivity(this);
        IncomeAdapter incomeAdapter=new IncomeAdapter(ShowData.this,R.layout.data_item,incomes);
        ExpenseAdapter expenseAdapter=new ExpenseAdapter(ShowData.this,R.layout.data_item,expenses);
//        ListView listView=(ListView) findViewById(R.id.list_view);
//        ListView listView1=(ListView) findViewById(R.id.list_view);
//        listView1.setAdapter(expenseAdapter);
//        listView.setAdapter(incomeAdapter);
        Intent intent=getIntent();
        String data=intent.getStringExtra("showdata");
        if(data.equals("showincome"))
        {
            ListView listView=(ListView) findViewById(R.id.list_view);
            listView.setAdapter(incomeAdapter);
            Toast.makeText(ShowData.this,"showincome",Toast.LENGTH_LONG);
            Log.d("ShowData",data);
        }else{
            ListView listView1=(ListView) findViewById(R.id.list_view);
            listView1.setAdapter(expenseAdapter);
            Toast.makeText(ShowData.this,"showexpense",Toast.LENGTH_LONG);

        }

    }
}
