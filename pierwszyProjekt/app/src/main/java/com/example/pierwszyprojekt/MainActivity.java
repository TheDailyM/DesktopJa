package com.example.pierwszyprojekt;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button przycisk0;
    Button przycisk1;
    Button przycisk2;
    Button przycisk3;
    Button przycisk4;
    Button przycisk5;
    Button przycisk6;
    Button przycisk7;
    Button przycisk8;
    Button przycisk9;

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

        przycisk0 = findViewById(R.id.button_0);
        przycisk1 = findViewById(R.id.button_1);
        przycisk2 = findViewById(R.id.button_2);
        przycisk3 = findViewById(R.id.button_3);
        przycisk4 = findViewById(R.id.button_4);
        przycisk5 = findViewById(R.id.button_5);
        przycisk6 = findViewById(R.id.button_6);
        przycisk7 = findViewById(R.id.button_7);
        przycisk8 = findViewById(R.id.button_8);
        przycisk9 = findViewById(R.id.button_9);


        przycisk0.setOnClickListener(E ->{
            System.out.println("0");
        });
        przycisk1.setOnClickListener(E ->{
            System.out.println("1");
        });
        przycisk2.setOnClickListener(E ->{
            System.out.println("2");
        });
        przycisk3.setOnClickListener(E ->{
            System.out.println("3");
        });
        przycisk4.setOnClickListener(E ->{
            System.out.println("4");
        });
        przycisk5.setOnClickListener(E ->{
            System.out.println("5");
        });
        przycisk6.setOnClickListener(E ->{
            System.out.println("6");
        });
        przycisk7.setOnClickListener(E ->{
            System.out.println("7");
        });
        przycisk8.setOnClickListener(E ->{
            System.out.println("8");
        });
        przycisk9.setOnClickListener(E ->{
            System.out.println("9");
        });

    }
}