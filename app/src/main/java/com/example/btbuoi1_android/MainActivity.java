package com.example.btbuoi1_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = (Button) this.findViewById(R.id.go_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity1.class);
                myIntent.putExtra("text1", "This is text");
                myIntent.putExtra("text2", "This is long text");
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button button2 = (Button) this.findViewById(R.id.go_button2);
        button2.setOnClickListener(new View.OnClickListener() { // Sửa ở đây
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button button3 = (Button) this.findViewById(R.id.go_button3);
        button3.setOnClickListener(new View.OnClickListener() { // Sửa ở đây
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity3.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button button4 = (Button) this.findViewById(R.id.go_button4);
        button4.setOnClickListener(new View.OnClickListener() { // Sửa ở đây
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity4.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button button5 = (Button) this.findViewById(R.id.go_button5);
        button5.setOnClickListener(new View.OnClickListener() { // Sửa ở đây
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity5.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
