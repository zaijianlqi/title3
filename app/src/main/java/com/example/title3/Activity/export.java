package com.example.title3.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.title3.Expense;
import com.example.title3.Income;
import com.example.title3.R;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class export extends AppCompatActivity {

    private List<Income> incomes= DataSupport.findAll(Income.class);
    private List<Expense> expenses=DataSupport.findAll(Expense.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);

        List<String> permissionList=new ArrayList<>();
        if(ContextCompat.checkSelfPermission(export.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        if(!permissionList.isEmpty()){
            String[] permissions=permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(export.this,permissions,1);
        }else{
            initButton();
        }

        Button button_ei=(Button) findViewById(R.id.ei_button);
        button_ei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                // if(state.equals(Environment.MEDIA_MOUNTED)) {
                File SDPath = Environment.getExternalStorageDirectory();
                String filepath = SDPath.getPath();
                File file = new File(filepath, "1.txt");
                try {
                    PrintWriter out = new PrintWriter(file);
                    out.println("收入");
                    for (Income income : incomes) {
                        out.println("编号" + income.getId() + "  " + "Souce" + income.getSource() + "  " + "Number" + income.getNumber()
                                + "  " + "Time" + income.getTime());

                    }
                    Toast.makeText(export.this, "Hhhhhh", Toast.LENGTH_LONG).show();
                    Log.d("export.this", "HelloWord");
                    out.println("支出");
                    for (Expense expense : expenses) {
                        out.println("编号" + expense.getId() + "  " + "Souce" + expense.getSource() + "  " + "Number" + expense.getNumber()
                                + "  " + "Time" + expense.getTime());
                    }
                    out.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public void initButton()
    {
        Button button_ei=(Button) findViewById(R.id.ei_button);
        button_ei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state= Environment.getExternalStorageState();
               // if(state.equals(Environment.MEDIA_MOUNTED)) {
                    File SDPath = Environment.getExternalStorageDirectory();
                    String filepath = SDPath.getPath();
                    File file=new File(filepath,"1.txt");
                    try {
                        PrintWriter out=new PrintWriter(file);
                        out.println("收入");
                        for (Income income:incomes) {
                            out.println("编号"+income.getId()+"  "+"Souce"+income.getSource()+"  "+"Number"+income.getNumber()
                                    +"  "+"Time"+income.getTime());

                        }
                        Toast.makeText(export.this,"Hhhhhh",Toast.LENGTH_LONG);
                        Log.d("export.this", "HelloWord");
                        out.println("支出");
                        for (Expense expense:expenses) {
                            out.println("编号"+expense.getId()+"  "+"Souce"+expense.getSource()+"  "+"Number"+expense.getNumber()
                                    +"  "+"Time"+expense.getTime());
                        }
                        out.flush();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
           // }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults)
    {
        switch(requestCode)
        {
            case 1:
                if(grantResults.length>0){
                    for(int result:grantResults)
                    {
                        if(result!= PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"必须同意全部权限",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    initButton();
                }else{
                    Toast.makeText(this,"error",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

}
