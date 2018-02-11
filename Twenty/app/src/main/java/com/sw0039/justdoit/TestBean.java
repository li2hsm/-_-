package com.sw0039.justdoit;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 测试android-parcelable-intellij-plugin一键序列化数据bean
 */
public class TestBean implements Parcelable {

    private int id;
    private String name;
    private float score;
    private List<String> lessonName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeFloat(this.score);
        dest.writeStringList(this.lessonName);
    }

    public TestBean() {
    }

    protected TestBean(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.score = in.readFloat();
        this.lessonName = in.createStringArrayList();
    }

    public static final Parcelable.Creator<TestBean> CREATOR = new Parcelable.Creator<TestBean>() {
        @Override
        public TestBean createFromParcel(Parcel source) {
            return new TestBean(source);
        }

        @Override
        public TestBean[] newArray(int size) {
            return new TestBean[size];
        }
    };
}
