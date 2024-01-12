//看视频聊天
package com.example.myapplication;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class VideoActivity extends AppCompatActivity implements SurfaceHolder.Callback, View.OnClickListener {

    private MediaPlayer mPlayer = null;
    private SurfaceView sfv_show;
    private SurfaceHolder surfaceHolder;
    private Button btn_start;
    private Button btn_pause;

    private ListView list_one;
    private TextView txt_empty;
    private Button btn_add;

    private MyAdapter mAdapter = null;
    private List<Object> mData = null;
    private Context mContext = null;
    private int flag = 1;
    private DataMine mData_5 = null;   //用来临时放对象的
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mContext = VideoActivity.this;
        mData = new LinkedList<Object>();
        mAdapter = new MyAdapter((LinkedList<Object>) mData,mContext);
        bindViews();
    }

    private void bindViews() {
        sfv_show = (SurfaceView) findViewById(R.id.sfv_show);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_pause = (Button) findViewById(R.id.btn_pause);


        btn_start.setOnClickListener(this);
        btn_pause.setOnClickListener(this);


        //初始化SurfaceHolder类，SurfaceView的控制器
        surfaceHolder = sfv_show.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(320, 220);   //显示的分辨率,不设置为视频默认
        list_one = (ListView) findViewById(R.id.list_one);
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        btn_add = (Button) findViewById(R.id.btn_add);


        txt_empty.setText("暂无数据~");
        list_one.setAdapter(mAdapter);
        list_one.setEmptyView(txt_empty);
        btn_add.setOnClickListener(this);


        input = findViewById(R.id.input);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                mPlayer.start();
                break;
            case R.id.btn_pause:
                mPlayer.pause();
                break;

        }
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

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mPlayer = MediaPlayer.create(VideoActivity.this, R.raw.lesson);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.setDisplay(surfaceHolder);    //设置显示视频显示在SurfaceView上
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        }
        mPlayer.release();
    }
}
