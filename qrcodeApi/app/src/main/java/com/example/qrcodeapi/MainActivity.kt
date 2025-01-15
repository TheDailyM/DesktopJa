package com.example.qrcodeapi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    lateinit var buttonZamknij: Button;
    lateinit var miasto: EditText;
    lateinit var jakiemiasto: String;
    lateinit var wyswietlaczTemp: TextView;
    lateinit var apiInterface: ApiInterface;
    lateinit var buttonPotwierdx: Button;
    lateinit var wyswietlaczStacja: TextView;
    lateinit var wyswietlaczData: TextView;
    lateinit var wyswietlaczOpady: TextView;

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
        buttonPotwierdx = findViewById<Button>(R.id.button_potwierdx);
        wyswietlaczStacja = findViewById<TextView>(R.id.wyswietlaczStacja);
        wyswietlaczData = findViewById<TextView>(R.id.wyswietlaczData);
        wyswietlaczOpady = findViewById<TextView>(R.id.wyswietlaczOpady);



        buttonPotwierdx.setOnClickListener() {
            jakiemiasto = miasto.text.toString()
            println(jakiemiasto);
            akcja(jakiemiasto);
        }

        buttonZamknij.setOnClickListener {
            exitProcess(0);
        }

    }
    private fun getApiInterface(jakiemiasto: String) {
        apiInterface = RetrofitInstance.getInstance().create(MainActivity.ApiInterface::class.java)
        val call = apiInterface.getExampleData(jakiemiasto)
        call.enqueue(object : Callback<ExampleResponse> {
            override fun onResponse(call: Call<ExampleResponse>, response: Response<ExampleResponse>) {
                if (response.isSuccessful && response.body()!=null){
                    var body = response.body();
                    if (body != null) {
                        wyswietlaczTemp.text = body.temperatura;
                        wyswietlaczOpady.text = body.suma_opadu;
                        wyswietlaczData.text = body.data_pomiaru;
                        wyswietlaczStacja.text = body.stacja;
                    };

                    // TODO: Process data
                }
            }

            override fun onFailure(call: Call<ExampleResponse>, t: Throwable) {
                t.printStackTrace()
            }
        }).run {  }
    }

    fun akcja(jakiemiasto: String) {
        getApiInterface(jakiemiasto);

    }

    interface ApiInterface {
        @GET("api/data/synop/station/{miasto}")
        fun getExampleData(@Path("miasto") miasto:String): Call<ExampleResponse>
    }
}

data class ExampleResponse(
    val id_stacji: String,
    val stacja: String,
    val data_pomiaru: String,
    val temperatura: String,
    val suma_opadu: String
)
