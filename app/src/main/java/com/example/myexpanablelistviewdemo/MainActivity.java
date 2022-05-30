package com.example.myexpanablelistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

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
//       默认展开第一个
        els.expandGroup(0);
//        父级视图点击事件
        els.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, "父项"+groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        子集视图的点击事件
        els.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, "子项"+groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
//        折叠事件
        els.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, "折叠事件", Toast.LENGTH_SHORT).show();
            }
        });
//        展开事件监听
        els.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, "展开事件", Toast.LENGTH_SHORT).show();
            }
        });
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