package com.example.newsclient.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.newsclient.MainActivity;
import com.example.newsclient.R;

import java.util.List;

/**
 * Created by My Computer on 2017/11/28.
 */

public class DrawerLayoutAdapter extends ArrayAdapter<NewsType> {
    private int resourceId;
    public DrawerLayoutAdapter(Context context, int resource, List<NewsType> objects) {
        super(context, resource, objects);
        resourceId=resource;
        MainActivity.newsTypeList.add(new NewsType("新闻"));
        MainActivity.newsTypeList.add(new NewsType("区县"));
        MainActivity.newsTypeList.add(new NewsType("专题"));
        MainActivity.newsTypeList.add(new NewsType("组图"));
        MainActivity.newsTypeList.add(new NewsType("互动"));
        MainActivity.newsTypeList.add(new NewsType("投票"));
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsType type= getItem(position);
        View view;
        view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        TextView textView=(TextView)view.findViewById(R.id.drawer_layout_listviewtext);
        textView.setText(type.getType());
        ViewHolder viewHolder;
        if(convertView==null){
           view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)view.findViewById(R.id.drawer_layout_listviewtext);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder= (ViewHolder) view.getTag();
        }
        if (position%2==0){
            view.setBackgroundResource(R.drawable.pic_item_list_default);
        }
        viewHolder.textView.setText(type.getType());
        return view;
    }
    class ViewHolder{
        TextView textView;
    }
}
