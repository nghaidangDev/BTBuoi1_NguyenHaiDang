package com.example.btbuoi1_android;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView textEvt1;
    private TextView textEvt2;
    private static final String TAG = "TestGesture";

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.textEvt1 = findViewById(R.id.my_text_evt1);
        this.textEvt2 = findViewById(R.id.my_text_evt2);

        GestureDetector.OnGestureListener gestureListener = new MyOnGestureListener();
        GestureDetector.OnDoubleTapListener doubleTapListener = new MyOnDoubleTapListener();

        this.gestureDetector = new GestureDetector(this, gestureListener);
        this.gestureDetector.setOnDoubleTapListener(doubleTapListener);

        View rootView = this.findViewById(android.R.id.content).getRootView();

        rootView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent me){
                return gestureDetector.onTouchEvent(me);
            }
        });
        Log.e(TAG,"Running....");
    }

    class MyOnGestureListener implements GestureDetector.OnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            textEvt1.setText("onDown");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onDown");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            // Phương thức này có thể để trống hoặc xử lý nếu cần
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            // Phương thức này có thể để trống hoặc xử lý nếu cần
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            textEvt1.setText("onScroll");
            textEvt2.setText("Scrolling from: " + e1.getX() + ":" + e1.getY() + " to " + e2.getX() + ":" + e2.getY());
            Log.e(TAG, "onScroll");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            textEvt1.setText("onLongPress");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            textEvt1.setText("onFling");
            textEvt2.setText(e1.getX() + ":" + e1.getY() + " " + e2.getX() + ":" + e2.getY());
            Log.e(TAG, "onFling");
            return true;
        }
    }


    class MyOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            textEvt1.setText("onSingleTapConfirmed");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onSingleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            textEvt1.setText("onDoubleTap");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onDoubleTap");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            textEvt1.setText("onDoubleTapEvent");
            textEvt2.setText(e.getX() + ":" + e.getY());
            Log.e(TAG, "onDoubleTapEvent");
            return true;
        }
    }
}
