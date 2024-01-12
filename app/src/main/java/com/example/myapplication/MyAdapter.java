package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Jay on 2015/9/21 0021.
 */
public class MyAdapter extends BaseAdapter {
    private static final int TYPE_FRIEND = 0;
    private static final int TYPE_MINE = 1;

    private Context mContext;
    private LinkedList<Object> mData;



    public MyAdapter(LinkedList<Object> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }


    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof DataMine) {
            return TYPE_MINE;
        } else if (mData.get(position) instanceof DataFriend) {
            return TYPE_FRIEND;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //类别数目
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if(convertView == null){
            switch (type){
                case TYPE_MINE:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_mine, parent, false);
                    holder1 = new ViewHolder1();
                    holder1.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
                    holder1.txt_content = (TextView) convertView.findViewById(R.id.txt_content);
                    convertView.setTag(holder1);
                    break;
                case TYPE_FRIEND:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_friend, parent, false);
                    holder2 = new ViewHolder2();
                    holder2.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
                    holder2.txt_content = (TextView) convertView.findViewById(R.id.txt_content);
                    convertView.setTag(holder2);
                    break;
            }
        }else{
            switch (type){
                case TYPE_MINE:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_FRIEND:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }

        Object obj = mData.get(position);
        //设置下控件的值
        switch (type){
            case TYPE_MINE:
                DataMine app = (DataMine) obj;
                if(app != null){
                    holder1.img_icon.setImageResource(app.getImgId());
                    holder1.txt_content.setText(app.getContent());
                }
                break;
            case TYPE_FRIEND:
                DataFriend book = (DataFriend) obj;
                if(book != null){
                    holder2.img_icon.setImageResource(book.getImgId());
                    holder2.txt_content.setText(book.getContent());
                }
                break;
        }
        return convertView;
    }

    //添加一个元素
    public void add(DataMine data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    public void add(DataFriend data){
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }













    private class ViewHolder1 {
        ImageView img_icon;
        TextView txt_content;
    }
    private class ViewHolder2 {
        ImageView img_icon;
        TextView txt_content;
    }

}
