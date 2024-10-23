package com.example.btbuoi1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("text1");
        String value2 = intent.getStringExtra("text2");

        final TextView text1 = (TextView)this.findViewById(R.id.my_text1);
        final TextView text2 = (TextView)this.findViewById(R.id.my_text2);

        Button button = (Button)this.findViewById(R.id.my_button1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                text1.setText("You click button");
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                text2.setText("You long click button");
                return true;
            }
        });
    }
}