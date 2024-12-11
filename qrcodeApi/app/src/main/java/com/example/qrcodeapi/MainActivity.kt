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
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    lateinit var buttonZamknij: Button;
    lateinit var miasto: EditText;
    lateinit var jakiemiasto: String;
    lateinit var wyswietlaczTemp: TextView;
    lateinit var apiInterface: ApiInterface;

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
    private fun getApiInterface() {
        apiInterface = RetrofitInstance.getInstance().create(MainActivity.ApiInterface::class.java)
    }

    private fun getExampleData(){
        val call = apiInterface.getExampleData()
        call.enqueue(object : Callback<ExampleResponse> {
            override fun onResponse(call: Call<ExampleResponse>, response: Response<ExampleResponse>) {
                if (response.isSuccessful && response.body()!=null){
                    // TODO: Process data
                }
            }

            override fun onFailure(call: Call<ExampleResponse>, t: Throwable) {
                t.printStackTrace()
            }
        }
    }
    fun akcja(){
        getApiInterface();

    }

    interface ApiInterface {
        @GET("api/data/synop/station/jeleniagora")
        fun getExampleData(): Call<ExampleResponse>
    }
}

class ExampleResponse {
    public var id = 0;
    public var stacja = "";
    public var data: LocalDate = LocalDate.of(0,0,0);
    public var temp = 0.0;
    public var opady = 0.0;

}
