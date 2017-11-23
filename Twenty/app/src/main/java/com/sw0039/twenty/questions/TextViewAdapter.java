package com.sw0039.twenty.questions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sw0039.twenty.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
public class TextViewAdapter extends BaseAdapter{

    private List<String> mList = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;
    public TextViewAdapter(List<String> list,Context context){
        mList = list;
        mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.scrollview_listview_item, null);
            holder.mText = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mText.setText(mList.get(position));
        return convertView;
    }

    static class ViewHolder{
        public TextView mText;
    }
}
