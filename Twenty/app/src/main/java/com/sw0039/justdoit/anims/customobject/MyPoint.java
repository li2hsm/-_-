package com.sw0039.justdoit.anims.customobject;

public class MyPoint {

    private MyPoint myPoint;
    private float x;
    private float y;

    public void setPoint(float xx,float yy){
        myPoint = new MyPoint();
        myPoint.x = xx;
        myPoint.y = yy;
    }

    public MyPoint getPoint(){
        return myPoint;
    }
}
