package com.example.title3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.title3.ActivityCollector;
import com.example.title3.DAO.AddExpense;
import com.example.title3.DAO.AddIncome;
import com.example.title3.R;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCollector.addActivity(this);
        Button button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2=(Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
        Button button5=(Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        Button button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);
        Button button7=(Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8=(Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9=(Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Intent intent=new Intent(MainActivity.this, AddIncome.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1=new Intent(MainActivity.this, AddExpense.class);
                startActivity(intent1);
                break;
            case R.id.button3:
                Intent intent2=new Intent(MainActivity.this, ShowData.class);
                String data="showincome";
                intent2.putExtra("showdata",data);
                startActivity(intent2);
                break;
            case R.id.button4:
                Intent intent3=new Intent(MainActivity.this, ShowData.class);
                String data1="showexpense";
                intent3.putExtra("showdata",data1);
                startActivity(intent3);
                break;
            case R.id.button5:
                Intent intent4=new Intent(MainActivity.this, ShowChart.class);
                String data2="incomechart";
                intent4.putExtra("chartdata",data2);
                startActivity(intent4);//ActivityCollector.finishAll();
                break;
            case R.id.button6:
                Intent intent5=new Intent(MainActivity.this, ShowChart.class);
                String data3="expensechart";
                intent5.putExtra("chartdata",data3);
                startActivity(intent5);
                break;
            case R.id.button7:
                Intent intent6=new Intent(MainActivity.this, export.class);
                startActivity(intent6);
                break;
            case R.id.button8:
                Connector.getDatabase();
                break;
            case R.id.button9:
                ActivityCollector.finishAll();
                break;
        }
    }
}
