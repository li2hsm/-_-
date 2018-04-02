package com.hsm.justdoit.baseactivitys;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hsm.justdoit.R;
import com.hsm.justdoit.interfaces.PermissionCallBack;
import com.hsm.justdoit.utils.TypeFaceUtils;
import com.mylhyl.circledialog.CircleDialog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;

/**
 * activity基类
 */
public class HSMBaseActivity extends AppCompatActivity implements PermissionCallBack {

    @BindView(R2.id.head_left_btn)
    ImageButton headLeftBtn;
    @BindView(R.id.head_title)
    TextView headTitle;
    @BindView(R.id.head_right_txt)
    TextView headRightTxt;
    @BindView(R.id.head_layout)
    RelativeLayout headLayout;
    @BindView(R.id.mid_layout)
    LinearLayout midLayout;
    @BindView(R.id.bottom_layout)
    LinearLayout bottomLayout;

    private Unbinder mUnbinder = null;
    public Context mContext;

    //本地dialog
    private DialogFragment mDialog = null;

    //动态申请权限的flag
    private final int PERMISSION_REQUESTION_ID = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hsmbase);
        mContext = this;
        initHSMToast();
        mUnbinder = ButterKnife.bind(this);
    }

    /**
     * android6.0动态申请权限
     *
     * @param permissionMap
     */
    public void getPermission(Map<Integer, String> permissionMap) {
        //如果是6.0以下的系统，直接返回.
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }

        setPermissionCallBack(HSMBaseActivity.this);

        if (permissionMap == null || permissionMap.isEmpty()) {
            show1BtnDialog("提示", "权限名字为空，无法获取权限", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismissAllDialog();
                }
            });
            return;
        }

        //1,判断权限
        Iterator<Map.Entry<Integer, String>> itera_Entry = permissionMap.entrySet().iterator();
        List<String> permissionList = new ArrayList<>();
        while (itera_Entry.hasNext()) {
            Map.Entry<Integer, String> mapEntry = itera_Entry.next();
            String permissionName = mapEntry.getValue();
            if (ContextCompat.checkSelfPermission(mContext, permissionName) == PackageManager.PERMISSION_DENIED) {
                //2,没有该权限，解释权限
                ActivityCompat.shouldShowRequestPermissionRationale(HSMBaseActivity.this, permissionName);
                permissionList.add(permissionName);
            }
        }

        //3,根据数组里没有权限的个数，动态申请权限.
        if (permissionList.size() > 0) {
            String[] permissionArray = (String[]) permissionList.toArray();
            ActivityCompat.requestPermissions(HSMBaseActivity.this, permissionArray, PERMISSION_REQUESTION_ID);
        } else {
            if (mPermissionCallBack != null) {
                mPermissionCallBack.onPermissionSuccess();
            }
        }
    }

    /**
     * 4，6.0动态申请权限的结果。
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //这个函数处理申请权限后的结果之后的操作。
        if (requestCode == PERMISSION_REQUESTION_ID) {
            boolean isAllGranted = true;

            // 判断是否所有的权限都已经授予了
            for (int grant : grantResults) {
                if (grant != PackageManager.PERMISSION_GRANTED) {
                    isAllGranted = false;
                    break;
                }
            }

            if (isAllGranted) {
                // 如果所有的权限都授予了, 则执行备份代码
                if (mPermissionCallBack != null) {
                    mPermissionCallBack.onPermissionSuccess();
                }
            } else {
                show1BtnDialog("提示", "权限申请失败", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismissAllDialog();
                        if (mPermissionCallBack != null) {
                            mPermissionCallBack.onPermissionFail();
                        }
                    }
                });
            }
        }
    }

    //6.0动态申请权限之后的回调。
    public PermissionCallBack mPermissionCallBack = null;

    //6.0动态申请权限成功的回调
    @Override
    public void onPermissionSuccess() {

    }

    //6.0动态申请权限失败的回调
    @Override
    public void onPermissionFail() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void setPermissionCallBack(PermissionCallBack permissionCallBack) {
        mPermissionCallBack = permissionCallBack;
    }


    /**
     * 弹一个按钮的对话框
     *
     * @param title
     * @param msg
     * @param listener
     */
    public void show1BtnDialog(String title, String msg, View.OnClickListener listener) {
        mDialog = new CircleDialog.Builder()
                .setTitle("提示")
                .setText("权限名字为空，无法获取权限")
                .setPositive("确定", listener).create();
        mDialog.show(getSupportFragmentManager(), "对话框");
    }

    /**
     * 关闭对话框
     */
    public void dismissAllDialog() {
        if (mDialog != null && mDialog.isVisible()) {
            mDialog.dismissAllowingStateLoss();
            mDialog = null;
        }
    }

    /**
     * 显示toast,
     *
     * @param msg  显示信息
     * @param type 0-top,1-center,2-bottom
     */
    public void showHSMToast(String msg, int type) {
        if (TextUtils.isEmpty(msg)) {
            msg = "空信息";
        }
        Toast toast = Toasty.normal(mContext, msg);
        switch (type) {
            case 0:
                //top
                toast.setGravity(Gravity.TOP, 0, 0);
                break;
            case 1:
                //center
                toast.setGravity(Gravity.CENTER, 0, 0);
                break;
            case 2:
                //bottom
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                break;
            default:
                break;
        }
        toast.show();
    }

    /**
     * 初始化多功能toast
     * Toasty.Config.reset();//可重置下面的设置
     */
    public void initHSMToast() {
        Toasty.Config.getInstance()
                .setErrorColor(getResources().getColor(R.color.red_color)) // optional
                .setInfoColor(getResources().getColor(R.color.hint_text_color)) // optional
                .setSuccessColor(getResources().getColor(R.color.theme_color)) // optional
                .setWarningColor(getResources().getColor(R.color.yellow_color)) // optional
                .setTextColor(getResources().getColor(R.color.normal_text_color)) // optional
                .tintIcon(true) // optional (apply textColor also to the icon)
                .setToastTypeface(TypeFaceUtils.getKaiChinese(mContext)) // optional
                .setTextSize(14) // sp
                .apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
