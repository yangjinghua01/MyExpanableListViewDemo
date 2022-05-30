package com.example.myexpanablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseExpandableListAdapter {
    private List<String>parents;
    private List<List<String>>child;
    private Context context;
    private TextView par,chi;
    public Adapter(Context context,List<String>parents,List<List<String>>child) {
        this.parents =parents;
        this.child =child;
        this.context =context;
    }


    @Override
    public int getGroupCount() {
        return parents.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parents.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String partext = parents.get(groupPosition);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.parentiten,parent,false);
        }
        par = convertView.findViewById(R.id.par);
        par.setText(partext);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String chitext = child.get(groupPosition).get(childPosition);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.childparent,parent,false);
        }
        chi = convertView.findViewById(R.id.chi);
        chi.setText(chitext);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
