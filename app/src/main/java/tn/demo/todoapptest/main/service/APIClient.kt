package tn.demo.todoapptest.main.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class APIClient {

    companion object {
        const val URL = "http://334c-84-14-204-196.ngrok.io"

        fun getClient(): TodoService  {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build().create(TodoService::class.java)

        }

    }

}