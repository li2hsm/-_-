package com.sw0039.justdoit.deal_bitmaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sw0039.justdoit.R;
import com.sw0039.justdoit.view.ShaderView;

/**
 * paint setShader()
 *
 */
public class ShaderTest extends AppCompatActivity implements View.OnClickListener {

    // 声明位图渲染对象
    private Shader[] shaders = new Shader[5];
    // 声明颜色数组
    private int[] colors;
    // 自定义视图类
    ShaderView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shader_test);
        myView = (ShaderView)findViewById(R.id.my_view);
        // 获得Bitmap实例
        Bitmap bm = BitmapFactory.decodeResource(getResources()
                , R.drawable.water);
        // 设置渐变的颜色组，也就是按红、绿、蓝的方式渐变
        colors = new int[] { Color.RED, Color.GREEN, Color.BLUE };
        // 实例化BitmapShader，x坐标方向重复图形，y坐标方向镜像图形
        shaders[0] = new BitmapShader(bm, Shader.TileMode.REPEAT,
                Shader.TileMode.MIRROR);
        // 实例化LinearGradient 线性渐变
        shaders[1] = new LinearGradient(0, 0, 100, 100
                , colors, null, Shader.TileMode.REPEAT);
        // 实例化RadialGradient 圆形渐变
        shaders[2] = new RadialGradient(100, 100, 80, colors, null,
                Shader.TileMode.REPEAT);
        // 实例化SweepGradient 角度渐变
        shaders[3] = new SweepGradient(160, 160, colors, null);
        // 实例化ComposeShader 组合渐变
        shaders[4] = new ComposeShader(shaders[1], shaders[2],
                PorterDuff.Mode.DARKEN);
        Button bn1 = (Button)findViewById(R.id.bn1);
        Button bn2 = (Button)findViewById(R.id.bn2);
        Button bn3 = (Button)findViewById(R.id.bn3);
        Button bn4 = (Button)findViewById(R.id.bn4);
        Button bn5 = (Button)findViewById(R.id.bn5);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
        bn3.setOnClickListener(this);
        bn4.setOnClickListener(this);
        bn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View source)
    {
        switch(source.getId())
        {
            case R.id.bn1:
                myView.paint.setShader(shaders[0]);
                break;
            case R.id.bn2:
                myView.paint.setShader(shaders[1]);
                break;
            case R.id.bn3:
                myView.paint.setShader(shaders[2]);
                break;
            case R.id.bn4:
                myView.paint.setShader(shaders[3]);
                break;
            case R.id.bn5:
                myView.paint.setShader(shaders[4]);
                break;
        }
        // 重绘界面
        myView.invalidate();
    }
}
