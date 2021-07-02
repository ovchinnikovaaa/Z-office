package com.example.zoffice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class AnalyticsActivity extends AppCompatActivity {

    private static final String TAG = "AnalyticsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        /* Создаем Line Chart */

        /* LineChart mChart = findViewById(R.id.lineChart);

        LineChart mChart2 = findViewById(R.id.lineChart2);

        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(false);
        mChart.getDescription().setEnabled(false);

        mChart2.setDragEnabled(true);
        mChart2.setScaleEnabled(false);
        mChart2.getDescription().setEnabled(false);

//        LimitLine upperLimit = new LimitLine(65f, "Too High");
//        upperLimit.setLineWidth(4f);
//        upperLimit.enableDashedLine(10f, 10f, 0);
//        upperLimit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        upperLimit.setTextSize(15f);

        LimitLine lowerLimit = new LimitLine(35f, "Too Low");
        lowerLimit.setLineWidth(1f);
        lowerLimit.enableDashedLine(10f, 10f, 10f);
        lowerLimit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        lowerLimit.setTextSize(6f);

        LimitLine lowerLimit2 = new LimitLine(35f, "Too Low");
        lowerLimit2.setLineWidth(1f);
        lowerLimit2.enableDashedLine(10f, 10f, 10f);
        lowerLimit2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        lowerLimit2.setTextSize(6f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
//        leftAxis.addLimitLine(upperLimit);
        leftAxis.addLimitLine(lowerLimit);
        leftAxis.setAxisMaximum(100f);
        leftAxis.setAxisMinimum(10f);
        leftAxis.enableGridDashedLine(10f, 10f, 0);
        leftAxis.setDrawLimitLinesBehindData(true);

        YAxis leftAxis2 = mChart2.getAxisLeft();
        leftAxis2.removeAllLimitLines();
//        leftAxis.addLimitLine(upperLimit);
        leftAxis2.addLimitLine(lowerLimit);
        leftAxis2.setAxisMaximum(100f);
        leftAxis2.setAxisMinimum(10f);
        leftAxis2.enableGridDashedLine(10f, 10f, 0);
        leftAxis2.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        mChart2.getAxisRight().setEnabled(false);

        ArrayList<Entry> yValues = new ArrayList<>();

        yValues.add(new Entry(0, 60));
        yValues.add(new Entry(1, 50));
        yValues.add(new Entry(2, 70));
        yValues.add(new Entry(3, 30));
        yValues.add(new Entry(4, 50));
        yValues.add(new Entry(5, 60));
        yValues.add(new Entry(6, 65));

        LineDataSet set1 = new LineDataSet(yValues, "Прибыль");
        set1.setFillAlpha(110);

        set1.setColor(Color.BLUE);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);

        mChart.setData(data);

        ArrayList<Entry> yValues2 = new ArrayList<>();

        yValues2.add(new Entry(0, 70));
        yValues2.add(new Entry(1, 40));
        yValues2.add(new Entry(2, 60));
        yValues2.add(new Entry(3, 80));
        yValues2.add(new Entry(4, 20));
        yValues2.add(new Entry(5, 10));
        yValues2.add(new Entry(6, 65));

        LineDataSet set2 = new LineDataSet(yValues2, "Выручка");
        set2.setFillAlpha(110);

        set2.setColor(Color.GREEN);

        ArrayList<ILineDataSet> dataSets2 = new ArrayList<>();
        dataSets2.add(set2);

        LineData data2 = new LineData(dataSets2);

        mChart2.setData(data2);

        /** Создаем Pie Chart */

        /*PieChart pieChart = findViewById(R.id.pieChart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> pieValues = new ArrayList<>();

        pieValues.add(new PieEntry(34f, "Russia"));
        pieValues.add(new PieEntry(23f, "USA"));
        pieValues.add(new PieEntry(14f, "UK"));
        pieValues.add(new PieEntry(35f, "India"));
        pieValues.add(new PieEntry(40f, "Germany"));
        pieValues.add(new PieEntry(23f, "Japan"));

        pieChart.animateY(1000);

        PieDataSet pieDataSet = new PieDataSet(pieValues, "Countries");
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData pieData = new PieData(pieDataSet);
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.WHITE);

        pieChart.setData(pieData);



//        String[] values = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
//
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setValueFormatter(new MyXAxisValueFormatter(values));
//        xAxis.setGranularity(1f);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);



        /* Bottom Navigation View */

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Accounting Selected
        //bottomNavigationView.setSelectedItemId(R.id.action_more);

        // Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_chat:
                        startActivity(new Intent(getApplicationContext(), ChatActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_alerts:
                        startActivity(new Intent(getApplicationContext(), AlertsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_information:
                        startActivity(new Intent(getApplicationContext(), InformationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_support:
                        startActivity(new Intent(getApplicationContext(), SupportActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    public void onChatClick(View view) {
        Intent intent = new Intent(AnalyticsActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    public void onAlertsClick(View view) {
        Intent intent = new Intent(AnalyticsActivity.this, AlertsActivity.class);
        startActivity(intent);
    }

    public void onInformationClick(View view) {
        Intent intent = new Intent(AnalyticsActivity.this, InformationActivity.class);
        startActivity(intent);
    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(AnalyticsActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void onSupportClick(View view) {
        Intent intent = new Intent(AnalyticsActivity.this, SupportActivity.class);
        startActivity(intent);
    }

    public static class MyXAxisValueFormatter extends ValueFormatter implements IAxisValueFormatter {

        public String[] mValue;

        public MyXAxisValueFormatter(String[] values) {
            this.mValue = values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValue[(int)value];
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(AnalyticsActivity.this,
                                    "You have been signed out.",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // Close activity
                            finish();
                        }
                    });
        }
        return true;
    }
}