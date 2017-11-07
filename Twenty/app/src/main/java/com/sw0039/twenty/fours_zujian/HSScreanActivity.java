package com.sw0039.twenty.fours_zujian;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sw0039.twenty.R;
import com.sw0039.twenty.utils.ActionTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 一，解决布局问题
 *     1.禁止切换横屏或竖屏
 *       可以在配置Activity的地方进行如下的配置
 *        android:screenOrientation="portrait"
 *       android:screenOrientation="landscape"
 *       或者 setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
 *           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 *      这样就可以保证是竖屏总是竖屏了，或者横屏总是横屏。
 *
 *      2.可以切换横屏或竖屏
 *        1）layout-land和layout-port目录对应，横竖屏不同的布局。
 *        2）onCreate()中判断横竖屏,加载不同的布局
 *        3）横竖屏切换用onConfigurationChanged,
 *           ①，android:configChanges="orientation|keyboardHidden|screenSize",从sdk 3.2+，当手机屏幕发现旋转，新增加一个screenSize，这个值也会跟着发生改变
 *           ②, @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    super.onConfigurationChanged(newConfig);

                    // Checks the orientation of the screen
                     if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                     Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();

                     ....

                     } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
                     Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();

                    .....
                    }
                }

    二、重新载入问题
        1.不需要重新载入
         在androidmanifest.xml中加入配置android:configChanges="orientation|keyboardHidden"
         横竖屏切换时调用onConfigurationChanged(Configuration newConfig)

        2.重新载入，保存之前数据不变onSaveInstanceState()和onRestoreInstanceState()
            Android横竖屏切换时会触发onSaveInstanceState，而还原时会产生onRestoreInstanceState。

        3.重新载入，保存之前数据不变onRetainNonConfigurationInstance()和getLastNonConfigurationInstance()


 */

/**
 * 横竖屏切换
 * Created by Administrator on 2017/10/19.
 */
public class HSScreanActivity extends Activity {

    @BindView(R.id.edittext)
    TextView edittext;
    @BindView(R.id.change_screen_btn)
    Button changeScreenBtn;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

          //2,根据横竖屏加载不同的布局
//        changeLayoutByHS();
        setContentView(R.layout.hs_screen_activity);
        ActionTools.showLog(this,"onCreate()");
        mContext = this;
        ButterKnife.bind(this);

        //3,获取销毁的时候保存的数据
//        getRetainNonConfigurationData();

        //1,禁止布局切换的方法,设置为竖屏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * 根据横竖屏加载不同的布局
     */
    public void changeLayoutByHS(){
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("info", "landscape");
//            setContentView(R.layout.hs_screen_activity);
        }
        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("info", "portrait");
//            setContentView(R.layout.hs_screen_activity);
        }
    }

    @OnClick(R.id.change_screen_btn)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.change_screen_btn://横竖屏切换

                break;
        }
    }

    //----start---------onRetainNonConfigurationInstance()保存数据-----------------------
//    public void getRetainNonConfigurationData(){
//        MyDataObject data = (MyDataObject) getLastNonConfigurationInstance();
//        if (data == null) {
//            data = loadMyData();
//        }else{
//            int times = data.getTimes();
//            data.setTimes(times+1);
//        }
//
//        edittext.setText(data.getCurrentTime()+"\n"+data.getTimes()+"");
//    }
//
//    private MyDataObject loadMyData() {
//        MyDataObject mydata = new MyDataObject();
//        mydata.setCurrentTime(ActionTools.getCurrentTimeSS());
//        return mydata;
//    }
//
//    //横竖屏切换时，界面销毁之前收集数据
//    //在onstop和ondesdroy之间调用。
    @Override
    public Object onRetainNonConfigurationInstance() {
//        final MyDataObject data = collectMyLoadedData();
//        return data;
        ActionTools.showLog(this,"onRetainNonConfigurationInstance()");
        return null;
    }
//
//    /**
//     * 收集数据
//     * @return
//     */
//    private MyDataObject collectMyLoadedData() {
//        MyDataObject mydata = new MyDataObject();
//        mydata.setCurrentTime(edittext.getText().toString().split("\n")[0]);
//        mydata.setTimes(Integer.parseInt(edittext.getText().toString().split("\n")[1]));
//        return mydata;
//    }
    //----end---------onRetainNonConfigurationInstance()保存数据-----------------------

    //-----start--------onSaveInstanceState()保存数据-----------------------
    //保存数据
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ActionTools.showLog(this,"onRestoreInstanceState()");
        if(null!=savedInstanceState){
            String aa = savedInstanceState.getString("str");
            edittext.setText(aa);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ActionTools.showLog(this,"onSaveInstanceState()");
        String ad = "activity 被系统回收了怎么办？";
        outState.putString("str",ad);
    }
    //-----end--------onSaveInstanceState()保存数据-----------------------


    /**
     * 屏幕切换过程中的生命周期变化过程
     * onPause()->onSaveInstanceState()->onStop()->
     * onRetainNonConfigurationInstance()->onDestroy()->onCreate()->
     * onStart()->onRestoreInstanceState()->onResume()
     */
    //----start--------测试屏幕切换过程中的生命周期----------------------
    @Override
    protected void onRestart() {
        super.onRestart();
        ActionTools.showLog(this,"onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActionTools.showLog(this,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActionTools.showLog(this,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ActionTools.showLog(this,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        ActionTools.showLog(this,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActionTools.showLog(this,"onDestroy()");
    }

    //----end--------测试屏幕切换过程中的生命周期----------------------
}
