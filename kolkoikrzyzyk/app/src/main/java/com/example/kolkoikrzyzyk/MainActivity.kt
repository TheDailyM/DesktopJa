package com.example.kolkoikrzyzyk

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var button1:Button;
    private lateinit var button2:Button;
    private lateinit var button3:Button;
    private lateinit var button4:Button;
    private lateinit var button5:Button;
    private lateinit var button6:Button;
    private lateinit var button7:Button;
    private lateinit var button8:Button;
    private lateinit var button9:Button;
    private var zmienna =1;
    private lateinit var tab:List<Button>;
    private var wygraneX =0;
    private var wygraneO =0;
    private lateinit var wynik:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        println("sprawdam czy działa");
        tab = listOf(button1, button2, button3, button4, button5, button6, button7, button8, button9);
        wynik = findViewById(R.id.wyniktext);

        button1.setOnClickListener{
            if (button1.text == ""){
                if (zmienna == 1){
                    button1.text = "X";
                    zmienna--;
                }
                else{
                    button1.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button2.setOnClickListener{
            if (button2.text == ""){
                if (zmienna == 1){
                    button2.text = "X";
                    zmienna--;
                }
                else{
                    button2.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button3.setOnClickListener{
            if (button3.text =="") {
                if (zmienna == 1) {
                    button3.text = "X";
                    zmienna--;
                } else {
                    button3.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button4.setOnClickListener{
            if (button4.text == "") {
                if (zmienna == 1) {
                    button4.text = "X";
                    zmienna--;
                } else {
                    button4.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button5.setOnClickListener{
            if (button5.text == ""){
                if (zmienna == 1){
                    button5.text = "X";
                    zmienna--;
                }
                else{
                    button5.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button6.setOnClickListener{
            if (button6.text == ""){
                if (zmienna == 1){
                    button6.text = "X";
                    zmienna--;
                }
                else{
                    button6.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button7.setOnClickListener{
            if (button7.text == ""){
                if (zmienna == 1){
                    button7.text = "X";
                    zmienna--;
                }
                else{
                    button7.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button8.setOnClickListener{
            if (button8.text == ""){
                if (zmienna == 1){
                    button8.text = "X";
                    zmienna--;
                }
                else{
                    button8.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }

        button9.setOnClickListener{
            if (button9.text == ""){
                if (zmienna == 1){
                    button9.text = "X";
                    zmienna--;
                }
                else{
                    button9.text = "0";
                    zmienna++;
                }
                spr();
                tie();
            }
        }





    }
    private fun tie(){
        var result = true;
        for (el in tab) {
            result = result && el.text.isNotEmpty();
        }

//        if (
//                    (button1.text == "X" || button1.text == "0") && (button2.text == "X" || button2.text == "0") &&
//                    (button3.text == "X" || button3.text == "0") && (button4.text == "X" || button4.text == "0") &&
//                    (button5.text == "X" || button5.text == "0") && (button6.text == "X" || button6.text == "0") &&
//                    (button7.text == "X" || button7.text == "0") && (button8.text == "X" || button8.text == "0") &&
//                    (button9.text == "X" || button9.text == "0")
//           )

        if (result)
        {
            for(el in tab) {
                el.text = "";
            }
            Toast.makeText(this, "Remis", Toast.LENGTH_LONG).show();
        }
    }

     private fun spr(){
        if (button1.text == "X" && button2.text == "X" && button3.text == "X" || button1.text == "0" && button2.text == "0" && button3.text == "0"){
            win(arg1 = button1.text.toString());
        }
        if (button4.text == "X" && button5.text == "X" && button6.text == "X" || button4.text == "0" && button5.text == "0" && button6.text == "0"){
            win(arg1 = button4.text.toString());
        }
        if (button7.text == "X" && button8.text == "X" && button9.text == "X" || button7.text == "0" && button8.text == "0" && button9.text == "0"){
            win(arg1 = button7.text.toString());
        }
        if (button1.text == "X" && button4.text == "X" && button7.text == "X" || button1.text == "0" && button4.text == "0" && button7.text == "0"){
            win(arg1 = button1.text.toString());
        }
        if (button2.text == "X" && button5.text == "X" && button8.text == "X" || button2.text == "0" && button5.text == "0" && button8.text == "0"){
            win(arg1 = button2.text.toString());
        }
        if (button3.text == "X" && button6.text == "X" && button9.text == "X" || button3.text == "0" && button6.text == "0" && button9.text == "0"){
            win(arg1 = button3.text.toString());
        }
        if (button1.text == "X" && button5.text == "X" && button9.text == "X" || button1.text == "0" && button5.text == "0" && button9.text == "0"){
            win(arg1 = button1.text.toString());
        }
        if (button3.text == "X" && button5.text == "X" && button7.text == "X" || button3.text == "0" && button5.text == "0" && button7.text == "0"){
            win(arg1 = button3.text.toString());
        }
    }

    private fun win(arg1: String){
        Toast.makeText(this, "Gracz $arg1 wygrał/a", Toast.LENGTH_LONG).show();
        for(el in tab) {
            el.text = "";
        }

        if (arg1 == "X"){
            wygraneX++
        }
        else{
            wygraneO++
        }
        wynik.text = "X: $wygraneX:$wygraneO :0";
    }
}