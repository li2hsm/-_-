package com.sw0039.justdoit.questions.address_selector.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.sw0039.justdoit.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 地址选择对话框
 */
public class AddressSelectDialogFragment extends DialogFragment {

    @BindView(R.id.cancle_btn)
    Button cancleBtn;
    @BindView(R.id.ok_btn)
    Button okBtn;
    @BindView(R.id.btn_rly)
    RelativeLayout btnRly;
    @BindView(R.id.select_lly)
    LinearLayout selectLly;
    Unbinder unbinder;

    //数据list
    private List<String> dataLists = null;

    private final static String PARAMS_DATA = "data";

    public static AddressSelectDialogFragment getDialogInstense(ArrayList<String> dataLists) {
        AddressSelectDialogFragment addressSelectDialogFragment = new AddressSelectDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putStringArrayList(PARAMS_DATA, dataLists);
        addressSelectDialogFragment.setArguments(bundle);
        return addressSelectDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewGroup = inflater.inflate(R.layout.address_select_dialogfragment, null);
        unbinder = ButterKnife.bind(this, viewGroup);
        dataLists = getParams();

        addListView();
        return viewGroup;
    }

    /**
     * 往布局里添加listview
     */
    private void addListView() {

    }

    /**
     * 获取参数
     *
     * @return
     */
    private List<String> getParams() {
        return getArguments() != null ? getArguments().getStringArrayList(PARAMS_DATA) : null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.cancle_btn, R.id.ok_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cancle_btn:
                dismiss();
                break;
            case R.id.ok_btn:
                dismiss();
                break;
        }
    }
}
