package com.gys.android.harmony.Graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.gys.android.harmony.R;

import java.util.ArrayList;

public class BarChart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        com.github.mikephil.charting.charts.BarChart barChart = findViewById(R.id.barchart);


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(40, 0));
        entries.add(new BarEntry(80, 1));

        BarDataSet bardataset = new BarDataSet(entries, "Cells");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Normal Average");
        labels.add("Your Usage");

        BarData data = new BarData(labels, bardataset);
        barChart.setData(data); // set the data and list of lables into chart

        barChart.setDescription("Results");  // set the description

        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);

        barChart.animateY(5000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}