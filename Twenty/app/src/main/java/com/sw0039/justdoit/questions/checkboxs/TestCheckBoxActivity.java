package com.sw0039.justdoit.questions.checkboxs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;

import com.sw0039.justdoit.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TestCheckBoxActivity extends AppCompatActivity {

    @BindView(R.id.checkbox)
    CheckBox mCheckbox;
    @BindView(R.id.btn)
    Button mBtn;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_check_box);
        mUnbinder = ButterKnife.bind(this);
        action();
    }

    private void action() {

    }

    @OnClick({R.id.btn})
    public void onMyClick(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
