package com.example.lightsensorapp

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

lateinit var Pole: TextView
lateinit var backgroud: LinearLayout

class MainActivity : AppCompatActivity(), SensorEventListener {

    private var mSensorManager: SensorManager? = null
    private var mAccelerometer: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Pole = findViewById<TextView>(R.id.text)
        backgroud = findViewById<LinearLayout>(R.id.LinearLayout)

        SensorActivity()
    }
    fun SensorActivity() {
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)
        println(mAccelerometer)
    }
    override fun onSensorChanged(event: SensorEvent?) {
        var zmienna = event?.values?.get(0)
        Pole.text = zmienna.toString()
        var hue = zmienna!! / 400;
        backgroud.background.alpha = hue.toInt();
    }
    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(this,mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}