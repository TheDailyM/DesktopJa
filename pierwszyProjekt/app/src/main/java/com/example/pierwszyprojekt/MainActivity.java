package com.example.pierwszyprojekt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
    TextView wyswietlacz;
    Button dodawanie;
    int pierwsza_liczba;
    int druga_liczba;
    int wynik;
    char dzialanie;
    Button oblicz_wynik;
    Button odejmowanie;
    Button mnozenie;
    Button dzielenie;

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
        wyswietlacz = findViewById(R.id.wyswietlacz);
        dodawanie = findViewById(R.id.button_addition);
        oblicz_wynik = findViewById(R.id.button_result);
        dodawanie = findViewById(R.id.button_subtraction);
        mnozenie = findViewById(R.id.button_multiplication);
        dzielenie = findViewById(R.id.button_division);

        przycisk0.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"0");
        });
        przycisk1.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"1");
        });
        przycisk2.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"2");
        });
        przycisk3.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"3");
        });
        przycisk4.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"4");
        });
        przycisk5.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"5");
        });
        przycisk6.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"6");
        });
        przycisk7.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"7");
        });
        przycisk8.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"8");
        });
        przycisk9.setOnClickListener(E ->{
            wyswietlacz.setText(wyswietlacz.getText()+"9");
        });
        dodawanie.setOnClickListener(E ->{
            if (pierwsza_liczba == 0) {
                pierwsza_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            else {
                druga_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            dzialanie = '+';

        });
        oblicz_wynik.setOnClickListener(E ->{
            druga_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            switch (dzialanie){
                case '+':
                    wynik = pierwsza_liczba + druga_liczba;
                case '-':
                    wynik = pierwsza_liczba - druga_liczba;
                case '*':
                    wynik = pierwsza_liczba * druga_liczba;
                case '/':
                    if (druga_liczba != 0){
                        wynik = pierwsza_liczba / druga_liczba;
                    }
                    else {
                        wyswietlacz.setText("BŁĄD");
                    }
            }
            wyswietlacz.setText(String.valueOf(wynik));
            pierwsza_liczba = wynik;
        });
        odejmowanie.setOnClickListener(E ->{
            if (pierwsza_liczba == 0 ){
                pierwsza_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            else {
                druga_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            dzialanie = '-';
        });
        mnozenie.setOnClickListener(E ->{
            if (pierwsza_liczba == 0){
                pierwsza_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            else {
                druga_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            dzialanie = '*';
        });
        dzielenie.setOnClickListener(E ->{
            if (pierwsza_liczba == 0){
                pierwsza_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            else {
                druga_liczba = Integer.getInteger(wyswietlacz.getText().toString());
            }
            dzialanie = '/';
        });

    }
}