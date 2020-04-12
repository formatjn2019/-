package com.example.hrd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.hrd.View.Chessboard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hrdviewlayout);
        GridLayout gridLayout;
//        gridLayout=(GridLayout)findViewById(R.id.chessboard);
//        Button bt=new Button(this);
//        bt.setText("程序按钮");

//        GridLayout.LayoutParams lp=new GridLayout.LayoutParams();
//        lp.set
//
//
//
////        gridLayout.a
        Button bt=(Button)findViewById(R.id.testbt_add);
//        bt.set


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chessboard cb=findViewById(R.id.abslayout);
////                cb.refresh(null);
                cb.init();
            }
        });
//
//        Button bt2=(Button)findViewById(R.id.testbt_remove);
////        bt.set
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Chessboard cb=findViewById(R.id.chessboard);
////                cb.refresh(null);
//            }
//        });
    }
}
