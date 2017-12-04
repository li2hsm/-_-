package com.sw0039.twenty.chapters02.actionbars;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.sw0039.twenty.R;

/**
 * AnimationDrawable动画，可以停止的动画。
 */
public class AnimationDrawableActivity extends Activity {

    private Button bt_iniciar;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android065_main);

        bt_iniciar = (Button) findViewById(R.id.bt_iniciar);
        bt_iniciar.setText("启动");
        bt_iniciar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                imgView = (ImageView) findViewById(R.id.iv_animacion);
                imgView.setBackgroundResource(R.drawable.frame_animation);

                imgView.post(new Runnable() {
                    @Override
                    public void run() {
                        AnimationDrawable frame = (AnimationDrawable) imgView
                                .getBackground();
                        if (frame.isRunning()) {
                            bt_iniciar.setText("启动");
                            frame.stop();
                        } else {
                            bt_iniciar.setText("停止");
                            frame.stop();
                            frame.start();
                        }
                    }
                });
            }
        });
    }

}
