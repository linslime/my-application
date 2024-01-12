//聊天
package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list_one;
    private TextView txt_empty;
    private Button btn_add;
    private int flag = 1;
    private MyAdapter mAdapter = null;

    private List<Object> mData = null;
    private Context mContext = null;

    private DataMine mData_5 = null;   //用来临时放对象的
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mContext = ChatActivity.this;
        mData = new LinkedList<Object>();
        mAdapter = new MyAdapter((LinkedList<Object>) mData, mContext);

        bindViews();

    }

    private void bindViews() {

        list_one = (ListView) findViewById(R.id.list_one);
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        btn_add = (Button) findViewById(R.id.btn_add);

        list_one.setAdapter(mAdapter);

        list_one.setEmptyView(txt_empty);
        txt_empty.setText("暂无数据~");

        btn_add.setOnClickListener(this);


        input = findViewById(R.id.input);
    }


    @Override
    public void onClick(View v) {
        String str = input.getText().toString();
        if (v.getId() == R.id.btn_add && TextUtils.isEmpty(str) == false) {
            mAdapter.add(new DataMine(R.mipmap.ic_icon_qitao, str));
            if(flag == 1){
                mAdapter.add(new DataFriend(R.mipmap.ic_friend,"这个好有趣啊"));
                flag++;
            }else if(flag == 2){
                mAdapter.add(new DataFriend(R.mipmap.ic_friend,"是这样的呢"));
                flag++;
            }

        }
    }
}