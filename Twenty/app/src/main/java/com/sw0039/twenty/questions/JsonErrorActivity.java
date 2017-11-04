package com.sw0039.twenty.questions;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sw0039.twenty.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * json错误
 * Created by Administrator on 2017/10/20.
 */
public class JsonErrorActivity extends Activity {

    String jsonStr = new String("{\"id\":\"123\",\"name\":\"张三\",\"age\":\"30\"}");

    @BindView(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_error_activity);
        ButterKnife.bind(this);

//        getBeanFromJsonStr();

        testChildM();
    }

    /**
     * 4、jvm的执行过程
     （1）子类B 的构造方法被调用，实例化一个B对象，B对象的成员被初始化
     （2）jvm隐含的调用父类的构造方法,实例化一个A对象，A对象的成员被初始化。
     （3）由于A对象的getID()未被屏蔽，所以调用的A对象的getID()函数。
     那么，在这里A的成员函数当然是访问自己的成员变量了。
     */
    private void testChildM() {
        ClassB classB = new ClassB();//子类和父类有相同的id的变量声明
        textview.setText(classB.getId());//此处打印的是classA
    }

    /**
     * 报错：Caused by: java.lang.IllegalArgumentException: class com.sw0039.twenty.questions.ClassB declares multiple JSON fields named id
     * 原因：子类拥有跟父类一样的变量声明。
     */
    private void getBeanFromJsonStr() {
        Gson gson = new Gson();
        ClassB classB = null;
        try {
            classB = gson.fromJson(jsonStr, ClassB.class);
        } catch (JsonSyntaxException js) {
            String errormsg = js.getMessage();
            textview.setText(errormsg);
        }
    }
}
