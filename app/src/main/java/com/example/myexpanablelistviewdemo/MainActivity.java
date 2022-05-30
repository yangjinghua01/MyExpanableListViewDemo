package com.example.myexpanablelistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView els;
    private Adapter adapter;
    private List<String> parents = new ArrayList<>();
    private List<List<String>>child = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        els = findViewById(R.id.els);
        initdata();
        adapter = new Adapter(MainActivity.this,parents,child);
        els.setAdapter(adapter);
        Log.i("TAGXXGC", "onCreate:parents "+child.size());
        Log.i("TAGXXGC", "onCreate:child "+child.toString());
    }

    private void initdata() {
//        父级的数据容器
        for (int i = 0; i < 5; i++) {
            parents.add("parent"+i);
        }
//        子项的具体内容
        List<String> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s.add("a"+i);
        }
//        包裹子项具体内容的具体容器他的size或者说length和父级的size和length是相同的
        for (int j = 0; j < 5; j++) {
            child.add(s);
        }
    }
}