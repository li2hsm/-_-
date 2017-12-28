package com.sw0039.justdoit.chapters02;

import android.os.Bundle;

import com.sw0039.justdoit.BaseRecyclerViewActivity;
import com.sw0039.justdoit.R;

/**
 * 第二章的功能.Android应用的界面编程
 */
public class Chapter02Activity extends BaseRecyclerViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("第二章,Android应用的界面编程");
        //添加数据
        String[] arrays = getResources().getStringArray(R.array.chapter02_list);
        String[] activitys = getResources().getStringArray(R.array.chapter02_activitys_list);
        addDatas(arrays,activitys);
    }

//    private void go2FunctionActivity(int pos) {
//
//        Intent intent = null;
//        switch (pos) {
//            case 0://第二章
//                intent = new Intent(mContext, CodeViewActivity.class);
//                break;
//            case 1://
//                intent = new Intent(Chapter02Activity.this, CustomViewActivity.class);
//                break;
//            case 2://
//                intent = new Intent(Chapter02Activity.this, ImageViewActivity.class);
//                break;
//            case 3://
//                intent = new Intent(Chapter02Activity.this, AbsoluteLayoutTest.class);
//                break;
//            case 4://
//                intent = new Intent(Chapter02Activity.this, FrameLayoutTest.class);
//                break;
//            case 5://
//                intent = new Intent(Chapter02Activity.this, GridLayoutTest.class);
//                break;
//            case 6://
//                intent = new Intent(Chapter02Activity.this, LinearLayoutTest.class);
//                break;
//            case 7://
//                intent = new Intent(Chapter02Activity.this, RelativeLayoutTest.class);
//                break;
//            case 8://
//                intent = new Intent(Chapter02Activity.this, TableLayoutTest.class);
//                break;
//            case 9://
//                intent = new Intent(Chapter02Activity.this, ButtonTest.class);
//                break;
//            case 10://
//                intent = new Intent(Chapter02Activity.this, CheckButtonTest.class);
//                break;
//            case 11://
//                intent = new Intent(Chapter02Activity.this, ChronometerTest.class);
//                break;
//            case 12://
//                intent = new Intent(Chapter02Activity.this, ClockTest.class);
//                break;
//            case 13://
//                intent = new Intent(Chapter02Activity.this, InputUI.class);
//                break;
//            case 14://
//                intent = new Intent(Chapter02Activity.this, NinePatchTest.class);
//                break;
//            case 15://
//                intent = new Intent(Chapter02Activity.this, TextViewTest.class);
//                break;
//            case 16://
//                intent = new Intent(Chapter02Activity.this, TextViewTest2.class);
//                break;
//            case 17://
//                intent = new Intent(Chapter02Activity.this, ToggleButtonTest.class);
//                break;
//            case 18://
//                intent = new Intent(Chapter02Activity.this, ImageButtonTest.class);
//                break;
//            case 19://
//                intent = new Intent(Chapter02Activity.this, ImageViewTest.class);
//                break;
//            case 20://
//                intent = new Intent(Chapter02Activity.this, QuickContactBadgeTest.class);
//                break;
//        }
//        if(null!=intent){
//            startActivity(intent);
//        }
//    }
}
