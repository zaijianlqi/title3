package com.example.title3.DAO;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.title3.Income;
import com.example.title3.R;

public class AddIncome extends AppCompatActivity {

    EditText iid;
    EditText souce;
    EditText number;
    EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
        iid=(EditText)findViewById(R.id.iid);
        souce=(EditText) findViewById(R.id.souce);
        number=(EditText) findViewById(R.id.number);
        time=(EditText) findViewById(R.id.time);

        Button insert3=(Button) findViewById(R.id.insert1);
        insert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Income income=new Income();
                //income.setId(Integer.parseInt(iid.getText().toString()));
                income.setSource(souce.getText().toString());
                income.setNumber(Integer.parseInt(number.getText().toString()));
                income.setTime(time.getText().toString());
                income.save();
            }
        });
    }
}
