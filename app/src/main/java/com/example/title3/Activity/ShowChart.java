package com.example.title3.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.title3.Expense;
import com.example.title3.Income;
import com.example.title3.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;

import org.litepal.crud.DataSupport;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShowChart extends AppCompatActivity {
    private BarChart day_fragment_bar_chart;
    private BarData mBarData;
    private List<Income> incomes= DataSupport.findAll(Income.class);
    private List<Expense> expenses=DataSupport.findAll(Expense.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chart);

        day_fragment_bar_chart= (BarChart) findViewById(R.id.chart1);

        Intent intent=getIntent();
        String data=intent.getStringExtra("chartdata");
        if(data.equals("incomechart"))
        {
            mBarData = getBarData1();
        }else{
            mBarData = getBarData2();
        }
        //mBarData = getBarData1();
        showBarChart(day_fragment_bar_chart, mBarData);

    }

    private void showBarChart(BarChart barChart, BarData barData) {
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView
        barChart.setNoDataTextDescription("You need to provide data for the chart.");

        barChart.setData(barData); // 设置数据

        barChart.setDrawBorders(false); //是否在折线图上添加边框

        barChart.setDescription("数据描述");// 数据描述
        barChart.setDescriptionPosition(100,20);//数据描述的位置
        barChart.setDescriptionColor(Color.RED);//数据的颜色
        barChart.setDescriptionTextSize(40);//数据字体大小

        barChart.setDrawGridBackground(false); // 是否显示表格颜色
        barChart.setGridBackgroundColor(Color.RED); // 表格的的颜色
        //barChart.setBackgroundColor(Color.BLACK);// 设置整个图标控件的背景
        barChart.setDrawBarShadow(false);//柱状图没有数据的部分是否显示阴影效果

        barChart.setTouchEnabled(true); // 设置是否可以触摸
        barChart.setDragEnabled(true);// 是否可以拖拽
        barChart.setScaleEnabled(true);// 是否可以缩放
        barChart.setAutoScaleMinMaxEnabled(true);
        barChart.setPinchZoom(true);//y轴的值是否跟随图表变换缩放;如果禁止，y轴的值会跟随图表变换缩放

        barChart.setDrawValueAboveBar(true);//柱状图上面的数值显示在柱子上面还是柱子里面

        //barChart.getXAxis().setDrawGridLines(false);//是否显示竖直标尺线
        barChart.getXAxis().setLabelsToSkip(0);//设置横坐标显示的间隔
//        barChart.getXAxis().setLabelRotationAngle(20);//设置横坐标倾斜角度
        barChart.getXAxis().setSpaceBetweenLabels(0);
        barChart.getXAxis().setDrawLabels(true);//是否显示X轴数值
        // barChart.getXAxis().setSpaceBetweenLabels(50);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴的位置 默认在上方

        barChart.getAxisRight().setDrawLabels(false);//右侧是否显示Y轴数值
        barChart.getAxisRight().setEnabled(false);//是否显示最右侧竖线
        barChart.getAxisRight().setDrawAxisLine(true);
        barChart.getAxisLeft().setDrawAxisLine(false);
        barChart.getXAxis().setDrawAxisLine(true);
        barChart.setMaxVisibleValueCount(10);


        YAxisValueFormatter custom = new MyYAxisValueFormatter();//自定义Y轴文字样式
        barChart.getAxisLeft().setValueFormatter(custom);

        barChart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART);//设置比例图标的位置
        barChart.getLegend().setDirection(Legend.LegendDirection.RIGHT_TO_LEFT);//设置比例图标和文字之间的位置方向
        barChart.getLegend().setTextColor(Color.RED);

        barChart.animateXY(2000,3000);
    }

    private BarData getBarData1() {
        ArrayList<String> xValues = new ArrayList<String>();
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        for (Income income:incomes) {
            xValues.add(income.getSource());
            yValues.add(new BarEntry((float)income.getNumber(), income.getId()-1));
        }


//
//        for (int i = 0; i < count; i++) {
//            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
//            yValues.add(new BarEntry(value, i));
//        }
//        barchart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴的位置
//        barchart.getXAxis().setDrawGridLines(false);//不显示网格


        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "collection");

        barDataSet.setBarSpacePercent(80);
        barDataSet.setVisible(true);//是否显示柱状图柱子
        barDataSet.setColor(Color.RED);//设置柱子颜色
        barDataSet.setDrawValues(true);//是否显示柱子上面的数值

        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();
        barDataSets.add(barDataSet); // add the datasets

        BarData barData = new BarData(xValues, barDataSet);

        return barData;
    }

    private BarData getBarData2() {
        ArrayList<String> xValues = new ArrayList<String>();
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();
        for (Expense expense:expenses) {
            xValues.add(expense.getSource());
            yValues.add(new BarEntry((float)expense.getNumber(), expense.getId()-1));
        }


//
//        for (int i = 0; i < count; i++) {
//            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;
//            yValues.add(new BarEntry(value, i));
//        }
//        barchart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);//设置X轴的位置
//        barchart.getXAxis().setDrawGridLines(false);//不显示网格


        // y轴的数据集合
        BarDataSet barDataSet = new BarDataSet(yValues, "collection");

        barDataSet.setBarSpacePercent(80);
        barDataSet.setVisible(true);//是否显示柱状图柱子
        barDataSet.setColor(Color.RED);//设置柱子颜色
        barDataSet.setDrawValues(true);//是否显示柱子上面的数值

        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();
        barDataSets.add(barDataSet); // add the datasets

        BarData barData = new BarData(xValues, barDataSet);

        return barData;
    }



    public class MyYAxisValueFormatter implements YAxisValueFormatter {

        private DecimalFormat mFormat;

        public MyYAxisValueFormatter() {
            mFormat = new DecimalFormat("###,###,###,##0");
        }

        @Override
        public String getFormattedValue(float value, YAxis yAxis) {
            return mFormat.format(value) + "K";
        }
    }
}
