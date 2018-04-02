package com.sw0039.justdoit.io;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sw0039.justdoit.R;

import java.io.File;
import java.util.Locale;

/**
 * 自动朗读 TTS
 */
public class TestTTSActivity extends AppCompatActivity {

    TextToSpeech tts;
    EditText editText;
    Button speech;
    Button record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tts);

        // 初始化TextToSpeech对象
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // 如果装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    // 设置使用美式英语朗读
                    int result = tts.setLanguage(Locale.US);
                    // 如果不支持所设置的语言
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(TestTTSActivity.this
                                , "TTS暂时不支持这种语言的朗读。"
                                , Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        editText = (EditText) findViewById(R.id.txt);
        speech = (Button) findViewById(R.id.speech);
        record = (Button) findViewById(R.id.record);
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 执行朗读
                tts.speak(editText.getText().toString(),
                        TextToSpeech.QUEUE_ADD, null, "speech");
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 将朗读文本的音频记录到指定文件
                tts.synthesizeToFile(editText.getText().toString(), null,
                        new File("/mnt/sdcard/sound.wav"), "record");
                Toast.makeText(TestTTSActivity.this, "声音记录成功！"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 关闭TextToSpeech对象
        if (tts != null) {
            tts.shutdown();
        }
    }
}
