package com.example.qrcodeapi

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET


class MainActivity : AppCompatActivity() {

    lateinit var buttonZamknij: Button;
    lateinit var miasto: EditText;
    lateinit var jakiemiasto: String;
    lateinit var wyswietlaczTemp: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonZamknij = findViewById<Button>(R.id.button);
        miasto = findViewById<EditText>(R.id.textMiasto);
        wyswietlaczTemp = findViewById<TextView>(R.id.wyswietlaczTemp);


        miasto.setOnFocusChangeListener {v, b -> run{
            jakiemiasto = miasto.text.toString()
            println(jakiemiasto);
            akcja();
        }}

        buttonZamknij.setOnClickListener {
            exitProcess(0);
        }

    }

    fun akcja(){
        wyswietlaczTemp.text = "90°C";
    }

    interface ApiInterface {
        @GET("end/point")
        fun getExampleData(): Call<ExampleResponse>
    }
}