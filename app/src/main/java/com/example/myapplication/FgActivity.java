package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FgActivity extends AppCompatActivity implements View.OnClickListener{

    //UI Object
    private TextView txt_topbar;
    private TextView txt_channel;
    private TextView txt_message;
    private TextView txt_better;
    private TextView txt_setting;
    private FrameLayout ly_content;

    //Fragment Object
    //private MyFragment fg1,fg2,fg3,fg4;
    private AFragment fa;
    private BFragment fb;
    private CFragment fc;
    private DFragment fd;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fg_activity);
        fManager = getFragmentManager();
        bindViews();
        txt_channel.performClick();   //模拟一次点击，既进去后选择第一项
    }

    //UI组件初始化与事件绑定
    private void bindViews() {
//        txt_topbar = (TextView) findViewById(R.id.txt_topbar);
        txt_channel = (TextView) findViewById(R.id.txt_channel);
        txt_message = (TextView) findViewById(R.id.txt_message);
        txt_better = (TextView) findViewById(R.id.txt_better);
        txt_setting = (TextView) findViewById(R.id.txt_setting);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        txt_channel.setOnClickListener(this);
        txt_message.setOnClickListener(this);
        txt_better.setOnClickListener(this);
        txt_setting.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected(){
        txt_channel.setSelected(false);
        txt_message.setSelected(false);
        txt_better.setSelected(false);
        txt_setting.setSelected(false);
    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fa != null)fragmentTransaction.hide(fa);
        if(fb != null)fragmentTransaction.hide(fb);
        if(fc != null)fragmentTransaction.hide(fc);
        if(fd != null)fragmentTransaction.hide(fd);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_channel:
                setSelected();
                txt_channel.setSelected(true);
                if(fa == null){
                    fa = new AFragment();
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, fa).commitAllowingStateLoss();
                    fa = null;
                }else{
                    fTransaction.show(fa);
                }
                break;
            case R.id.txt_message:
                setSelected();
                txt_message.setSelected(true);
                if(fb == null){
                    fb = new BFragment();
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, fb).commitAllowingStateLoss();
                    fb = null;
                }else{
                    fTransaction.show(fb);
                }
                break;
            case R.id.txt_better:
                setSelected();
                txt_better.setSelected(true);
                if(fc == null){
                    fc = new CFragment();
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, fc).commitAllowingStateLoss();
                    fc = null;
                }else{
                    fTransaction.show(fc);
                }
                break;
            case R.id.txt_setting:
                setSelected();
                txt_setting.setSelected(true);
                if(fd == null){
                    fd = new DFragment();
                    getFragmentManager().beginTransaction().replace(R.id.ly_content, fd).commitAllowingStateLoss();
                    fd = null;
                }else{
                    fTransaction.show(fd);
                }
                break;
        }
        fTransaction.commit();
    }
}
