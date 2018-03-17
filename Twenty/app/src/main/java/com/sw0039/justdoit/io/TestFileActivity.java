package com.sw0039.justdoit.io;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sw0039.justdoit.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 测试文件操作
 * 因为不同的系统针对不同的换行实别是不一样的?
 *      windows:\r\n
 *      linux:\n
 *      Mac:\r
 */
public class TestFileActivity extends AppCompatActivity {

    @BindView(R.id.content_text)
    TextView mContentText;
    @BindView(R.id.left_btn)
    Button mReadBtn;
    @BindView(R.id.right_btn)
    Button mWriteBtn;

    private String contentString = null;
    //文件的绝对路径
    private String fileName = null;
    private Context mCotext;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_file);
        mCotext = this;
        mUnbinder = ButterKnife.bind(this);

        contentString = mCotext.getString(R.string.cotent_string);

        mReadBtn.setText("从文件读取");
        mReadBtn.setEnabled(false);
        mWriteBtn.setText("写入文件");
    }

    @OnClick({R.id.left_btn, R.id.right_btn})
    public void onCustomClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                //判断文件是否存在，不存在就创建
                fileName = getFileFullPath();
                //写入文件
                writeFile();
                mReadBtn.setEnabled(true);
                break;
            case R.id.left_btn:
                //从文件读取
                String temp = readFile();
                mContentText.setText("\u3000\u3000"+temp);
                break;
        }
    }

    private String readFile() {
        File file = new File(fileName);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String result = br.readLine();
            Toast.makeText(TestFileActivity.this,
                    result,
                    Toast.LENGTH_LONG).show();
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(TestFileActivity.this,
                    "读取文件失败",
                    Toast.LENGTH_LONG).show();
        }
        return null;
    }

    private void writeFile() {
        FileOutputStream fos;
        try {
            File file = new File(fileName);
            //以追加的方式写入文件
            fos = new FileOutputStream(file,false);
            //推荐使用，具有良好的跨平台性
            String newLine = System.getProperty("line.separator");
            String finalString = contentString.replace("\n",newLine);
            fos.write(finalString.getBytes());
            fos.close();
            fos.flush();
            Toast.makeText(TestFileActivity.this,
                    "写入文件成功",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Toast.makeText(TestFileActivity.this,
                    "写入文件失败",
                    Toast.LENGTH_LONG).show();
        }

    }

    /**
     * 生产完整的写入文件路径
     *
     * @return
     */
    private String getFileFullPath() {
        String sdcardPath = FileUtils.getSdCardPath();
        String dir = sdcardPath + "/Twenty/";
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        String fileFullPath = dir + System.currentTimeMillis() + ".txt";
        File file = new File(fileFullPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileFullPath;
    }

    private String readData_DataFile() {
        String res = "";
        try {
            //从/data/data里面读数据
            FileInputStream fin = openFileInput(fileName);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            res = new String(buffer, "UTF-8");
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private void writeData_DataFile() {
        try {
            //往/data/data里面写数据
            FileOutputStream fout = openFileOutput(fileName, MODE_PRIVATE);
            byte[] bytes = contentString.getBytes();
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
