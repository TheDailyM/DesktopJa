package com.example.qrcodeapi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    object RetrofitInstance{
        private const val BASE_URL ="https://danepubliczne.imgw.pl/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }

}