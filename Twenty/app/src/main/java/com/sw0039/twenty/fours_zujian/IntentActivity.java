package com.sw0039.twenty.fours_zujian;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import com.sw0039.twenty.BaseCenterTextActivity;
import com.sw0039.twenty.MessageEvent;
import com.sw0039.twenty.R;
import com.sw0039.twenty.utils.ActionTools;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

/**
 * Intent与过滤器
 */
public class IntentActivity extends BaseCenterTextActivity {

    private Context mContext;
    private Resources mRes = null;

    private final MyHandler mHandler = new MyHandler(this);
    private static Runnable mRunnable = null;

    private static class MyHandler extends Handler {
        WeakReference<IntentActivity> mActivity;

        public MyHandler(IntentActivity activity) {
            mActivity = new WeakReference<IntentActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        mRes = getResources();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                //Intent组件名称
//                startActivityByXian();

                //Intent的操作
//                intentAction();

                //Intent 数据
//                intentData();

                //================start================intent测试=================================
                /**
                 * 测试，操作的规则测试 (如果过滤器指定了一个或者多个操作，要通过，intent必须设置一个匹配的操作；如果过滤器不指定操作，intent也不能指定操作)
                 * 规则如下:
                 * 1,要通过此过滤器，您在 Intent 中指定的操作必须与过滤器中列出的某一操作匹配。
                 * 2,如果该过滤器未列出任何操作，则 Intent 没有任何匹配项，因此所有 Intent 均无法通过测试。
                 * 3,但是，如果 Intent 未指定操作，则会通过测试（只要过滤器至少包含一个操作）。
                 */
                //1,要通过此过滤器，您在 Intent 中指定的操作必须与过滤器中列出的某一操作匹配。
//                testIntentAction1();
                //2,如果该过滤器未列出任何操作，则 Intent 没有任何匹配项，因此所有 Intent 均无法通过测试。
//                testIntentAction2();
                //3,如果该过滤器未列出任何操作，则 Intent 没有任何匹配项，因此所有 Intent 均无法通过测试。
                //但是，如果 Intent 未指定操作，则会通过测试（只要过滤器至少包含一个操作）。
//                testIntentAction3();

                /**
                 * 测试，类型的规则测试 (要想类别测试通过，要么intent不带类别，要么带的类别一定要匹配过滤器里定义的类别)
                 * 规则如下:
                 * 1,若要使 Intent 通过类别测试，则 Intent 中的每个类别均必须与过滤器中的类别匹配。
                 * 2,反之则未必然，Intent 过滤器声明的类别可以超出 Intent 中指定的数量，且 Intent 仍会通过测试。
                 * 3,因此，不含类别的 Intent 应当始终会通过此测试，无论过滤器中声明何种类别均是如此。
                 */
                //1,若要使 Intent 通过类别测试，则 Intent 中的每个类别均必须与过滤器中的类别匹配。
//                testIntentCategory1();
                //2,反之则未必然，Intent 过滤器声明的类别可以超出 Intent 中指定的数量，且 Intent 仍会通过测试。
//                testIntentCategory2();
                //3,因此，不含类别的 Intent 应当始终会通过此测试，无论过滤器中声明何种类别均是如此。
//                testIntentCategory3();

                /**
                 * 测试，数据的规则测试
                 * 规则如下:
                 *   1. 仅当过滤器未指定任何 URI 和 MIME 类型时，不含 URI 和 MIME 类型的 Intent 才会通过测试。
                 *   2. 对于包含 URI 但不含 MIME 类型（既未显式声明，也无法通过 URI 推断得出）的 Intent，仅当其 URI 与过滤器的 URI 格式匹配、
                 *      且过滤器同样未指定 MIME 类型时，才会通过测试。
                 *   3. 仅当过滤器列出相同的 MIME 类型且未指定 URI 格式时，包含 MIME 类型、但不含 URI 的 Intent 才会通过测试。
                 *   4. 仅当 MIME 类型与过滤器中列出的类型匹配时，同时包含 URI 类型和 MIME 类型（通过显式声明，或可以通过 URI 推断得出）的
                 *      Intent 才会通过测试的 MIME 类型部分。 如果 Intent 的 URI 与过滤器中的 URI 匹配，或者如果 Intent 具有 content:
                 *      或 file: URI 且过滤器未指定 URI，则 Intent 会通过测试的 URI 部分。 换言之，如果过滤器只是列出 MIME 类型，
                 *      则假定组件支持 content: 和 file: 数据。
                 */
                //1. 仅当过滤器未指定任何 URI 和 MIME 类型时，不含 URI 和 MIME 类型的 Intent 才会通过测试。
//                testIntentData1();
                //2. 对于包含 URI 但不含 MIME 类型（既未显式声明，也无法通过 URI 推断得出）的 Intent，仅当其 URI 与过滤器的 URI 格式匹配、
                //   且过滤器同样未指定 MIME 类型时，才会通过测试。
                testIntentData2();
                //================end================intent测试=================================
            }
        };
        mHandler.postDelayed(mRunnable, 1000);
    }


    /*===========start============数据的规则测试================================*/
    //1. 仅当过滤器未指定任何 URI 和 MIME 类型时，不含 URI 和 MIME 类型的 Intent 才会通过测试。
    //不能吊起页面
    private void testIntentData1() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
        //过滤器和intent都不加action,就能启动
        intent.setAction("android.intent.action.View");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }

    //2. 对于包含 URI 但不含 MIME 类型（既未显式声明，也无法通过 URI 推断得出）的 Intent，仅当其 URI 与过滤器的 URI 格式匹配、
    //   且过滤器同样未指定 MIME 类型时，才会通过测试。
    //不能吊起页面
    private void testIntentData2() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";

        Intent intent = new Intent();
        //过滤器和intent都不加action,就能启动
        intent.setAction("android.intent.action.View");
//        intent.addCategory("android.intent.category.BROWSABLE");
//        intent.setDataAndType(Uri.parse("http://www.baidu.com:8080/sdcard/hsm/"), "text/html");
//        intent.setType("text/html");
        intent.setData(Uri.parse("http://www.baidu.com"));
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }
    /*===========end============数据的规则测试================================*/

    /*===========start============类型的规则测试================================*/
    //1,若要使 Intent 通过类别测试，则 Intent 中的每个类别均必须与过滤器中的类别匹配。
    //能吊起页面
    private void testIntentCategory1() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
//        intent.setAction("android.intent.action.View");
        intent.addCategory("android.intent.category.BROWSABLE");

        //--加这一行就不能通过
//        intent.addCategory("android.intent.category.APP_EMAIL");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }

    //2,反之则未必然，Intent 过滤器声明的类别可以超出 Intent 中指定的数量，且 Intent 仍会通过测试。
    //能吊起页面
    private void testIntentCategory2() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
//        intent.setAction("android.intent.action.View");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }

    //3,因此，不含类别的 Intent 应当始终会通过此测试，无论过滤器中声明何种类别均是如此。
    //能吊起页面
    private void testIntentCategory3() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
//        intent.setAction("android.intent.action.View");
//        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }
    /*===========end============类型的规则测试================================*/

    /*===========start============操作的规则测试================================*/

    /**
     * 测试，操作测试的规则
     * 1,要通过此过滤器，您在 Intent 中指定的操作必须与过滤器中列出的某一操作匹配。
     * 能调起页面
     */
    private void testIntentAction1() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
        intent.setAction("android.intent.action.View");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }

    /**
     * 测试，操作测试的规则
     * 2,如果该过滤器未列出任何操作，则 Intent 没有任何匹配项，因此所有 Intent 均无法通过测试。
     * 不能调起页面
     */
    private void testIntentAction2() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
        intent.setAction("android.intent.action.View");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }

    /**
     * 测试，操作测试的规则
     * 3,如果该过滤器未列出任何操作，则 Intent 没有任何匹配项，因此所有 Intent 均无法通过测试,但是，如果 Intent 未指定操作，则会通过测试（只要过滤器至少包含一个操作）。
     * 能调起页面
     */
    private void testIntentAction3() {
        //自定义action启动隐式activity
        String showmsg = "自定义action启动隐式activity";
        Intent intent = new Intent();
//        intent.setAction("android.intent.action.View");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"), "image/*");
        //判断是否有能匹配这个intent的activity.
        if (null != intent.resolveActivity(getPackageManager())) {
            startActivity(intent);

            MessageEvent msg = new MessageEvent();
            msg.setmShowMsg(showmsg);
            EventBus.getDefault().postSticky(msg);
        } else {
            ActionTools.showToastShort(mContext, "没找到指定的activity");
        }
    }
    /*===========end============操作的规则测试================================*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    /*----start---------Intent的数据--------------*/
//    private void testIntentData(){
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.setData(mUri);
//        intent.setType("image/*");
////        intent.setDataAndType(mUri,"image/*");
//        intent.putExtra("pictureUrl","file://"+mPath+"/girl.jpg");
//        startActivity(intent);
//    }
    /*----end---------Intent的数据--------------*/

    /*----start---------Intent的操作--------------*/
    private void intentAction() {

        //1, Intent.ACTION_VIEW
//        Uri uri = Uri.parse("https://www.baidu.com");     //浏览器(网址必须带http)
//        Uri uri =Uri.parse("tel:1232333");              //拨号程序
//        Uri uri=Uri.parse("geo:39.899533,116.036476");  //打开地图定位
//        Intent it  = new Intent(Intent.ACTION_VIEW,uri);  //Intent.ACTION_VIEW不带引号
//        startActivity(it);

        //2,调用发送短信的程序,模拟器测试失败
//        sendSMS("18601792926","发短信");

        //3,
        //发送彩信,设备会提示选择合适的程序发送
//        Uri uri = Uri.parse("content://media/external/images/media/23"); //设备中的资源（图像或其他资源）
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.putExtra("sms_body", "内容");
//        intent.putExtra(Intent.EXTRA_STREAM, uri);
//        intent.setType("image/png");
//        startActivity(intent);

        //4,
        //Email
//        Intent intent=new Intent(Intent.ACTION_SEND);
//        String[] tos={"android1@163.com"};
//        String[] ccs={"244134860@qq.com"};
//        intent.putExtra(Intent.EXTRA_EMAIL, tos);
//        intent.putExtra(Intent.EXTRA_CC, ccs);
//        intent.putExtra(Intent.EXTRA_TEXT, "The email body text");
//        intent.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
//        intent.setType("message/rfc822");
//        //起一个选择器
//        startActivity(Intent.createChooser(intent, "Choose Email Client"));

    }

    /**
     * 直接调用短信接口发短信
     *
     * @param phoneNumber
     * @param message
     */
    public void sendSMS(String phoneNumber, String message) {

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri
                .parse("smsto:" + phoneNumber));
        // 如果需要将内容传过去增加如下代码
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
    /*----end---------Intent的操作--------------*/

    /*----start---------显示启动activity--------------*/

    /**
     * 显示启动activity组件的几种方式.
     */
    private void startActivityByXian() {

        //1,通过setComponent显示启动activity.
//        startActivityByComponentName();

        //2,通过setClass显示启动activity.
//        startActivityBySetClass();

        //3,通过setClassName()显示启动activity.
//        startActivityBySetClassName();

        //4,通过Intent()构造函数启动activity.
        startActivityByIntent();
    }

    private void startActivityByIntent() {
        Intent intent = new Intent(IntentActivity.this, IntentChildActivity.class);
        intent.putExtra(IntentChildActivity.MSG, "通过new Intent(context,a.class)启动activity");
        startActivity(intent);
    }

    private void startActivityBySetClassName() {
        Intent intent = new Intent();
        intent.setClassName(IntentActivity.this, getPackageName() + "." + "IntentChildActivity");
        intent.putExtra(IntentChildActivity.MSG, "通过intent.setClassName(context,'fullpakagename.classname')启动activity");
        startActivity(intent);
    }

    /**
     * 通过setClass显示启动activity.
     */
    private void startActivityBySetClass() {
        Intent intent = new Intent();
        intent.setClass(IntentActivity.this, IntentChildActivity.class);
        intent.putExtra(IntentChildActivity.MSG, "通过intent.setClass(context,a.class)启动activity");
        startActivity(intent);
    }

    /**
     * 通过setComponent显示启动activity.
     */
    private void startActivityByComponentName() {
        Intent intent = new Intent();
        ComponentName comp = new ComponentName(getPackageName(), "com.sw0039.twenty.fours_zujian.IntentChildActivity");
        intent.setComponent(comp);
        intent.putExtra(IntentChildActivity.MSG, "通过intent.setComponent(new ComponentName())启动activity");
        startActivity(intent);
    }
    /*----end---------显示启动activity--------------*/

}
