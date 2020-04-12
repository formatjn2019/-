package com.example.hrd.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.hrd.R;

public class Chessboard2222 extends GridLayout {
    enum buttonId {
        a, b, c, d, e, f, g, h, i, j, k, l
}


    public Chessboard2222(Context context) {
        super(context);
        init();
    }

    public Chessboard2222(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Chessboard2222(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Chessboard2222(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init() {
//        this.removeAllViews();
//        Button bt = new Button(this.getContext());
//        bt.setText("程序按钮");
//        GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
//        lp.width = 100;
//        lp.height = 100;
//        lp.setLayoutDirection(0);
//        lp.r
        /*可以用的*/
        View v=new View(this.getContext());
        TextView tv=new TextView(this.getContext());
        tv.setText("222");

        addView(tv);

//        GridView gv=new GridView(this.getContext());
//        extView tv=new TextView(this.getContext());
//        tv.setText("222");
//
//        addView(tv);



//        View v2=new View(this.getContext());
//        v.setColumnWidth(2);

//       this.addView(v);
//        Button bt=new Button(this.getContext());
//        bt.setText("程序按钮");
//         this.addView(bt);
    }

    public void refresh(char cArray[][]) {
        this.removeAllViews();
//        Button bt=new Button(this.getContext());
//        bt.setText("程序按钮");
//        LayoutParams lp=new LayoutParams();
//        lp.width=100;
//        lp.height=100;
//
//        bt.setLayoutParams();
////        lp.setLayoutDirection(0);
//        this.addView(bt,lp);
 //       Button bt;
//        for(int i=0;i<5;i++){
//            for(int j=0;j<4;j++){
//
//            }
//        }
    }

}
