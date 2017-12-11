package com.example.title3.DAO;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.title3.Expense;
import com.example.title3.R;

public class AddExpense extends AppCompatActivity {

    EditText iid;
    EditText souce;
    EditText number;
    EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);
        iid=(EditText)findViewById(R.id.iid1);
        souce=(EditText) findViewById(R.id.souce1);
        number=(EditText) findViewById(R.id.number1);
        time=(EditText) findViewById(R.id.time1);

        Button insert3=(Button) findViewById(R.id.insert2);
        insert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense expense=new Expense();
                //income.setId(Integer.parseInt(iid.getText().toString()));
                expense.setSource(souce.getText().toString());
                expense.setNumber(Integer.parseInt(number.getText().toString()));
                expense.setTime(time.getText().toString());
                expense.save();
            }
        });
    }
}
