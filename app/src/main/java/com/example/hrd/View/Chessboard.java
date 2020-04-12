package com.example.hrd.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsoluteLayout;
import android.widget.Button;

public class Chessboard extends AbsoluteLayout {
    int
    public Chessboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Chessboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Chessboard(Context context) {
        super(context);
    }
    public void init(){
        Button bt=new Button(this.getContext());
        bt.setWidth(100);
        bt.setHeight(200);
        bt.setX(0);
        bt.setY(0);
        bt.setText("按钮");
        addView(bt);
    }
}
