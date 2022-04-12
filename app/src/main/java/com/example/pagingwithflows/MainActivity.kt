package com.example.pagingwithflows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingwithflows.server_data.result
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var rva:adap
    lateinit var d:Viewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var interceptor=HttpLoggingInterceptor().apply {
            HttpLoggingInterceptor.Level.BODY
        }
        var client=OkHttpClient.Builder().addInterceptor(interceptor).build()
        var b="https://rickandmortyapi.com/api/"
        var s=Retrofit.Builder()
            .baseUrl(b)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        var ss=s.create(RetroInstance::class.java)

        lifecycleScope.launch{
           var s= ss.getData(1)
            Log.d("dataaa","data $s")

        }
         d=Viewmodel(ss)

        d.getdata()
        initRecyclerView()
        initviewmodel()
        Log.d("enter11","${d.result.value}")
    }

    fun initRecyclerView(){
        recyclerView.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            var decoration= DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            rva= adap()
            adapter=rva

        }


    }
    private fun initviewmodel(){
        lifecycleScope.launchWhenCreated {
            var s=d.result1.value
            rva.submitData(s)
            }
        }
    }