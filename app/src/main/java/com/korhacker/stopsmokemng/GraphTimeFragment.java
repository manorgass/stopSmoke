package com.korhacker.stopsmokemng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


public class GraphTimeFragment extends Fragment {

    public GraphTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mainView = inflater.inflate(R.layout.fragment_graph_time, null);


        // in this example, a LineChart is initialized from xml
        LineChart chart = (LineChart) mainView.findViewById(R.id.chart_time);

        // add tmp dataset

        List<Entry> entries = new ArrayList<Entry>();
        for(int i=1; i<30; i++)
            entries.add(new Entry(i,i));

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(0x11ff0f);

        LineData data = new LineData(dataSet);
        chart.setData(data);
        chart.invalidate();


        // Inflate the layout for this fragment
        return mainView;
    }
}

