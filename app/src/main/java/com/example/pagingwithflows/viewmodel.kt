package com.example.pagingwithflows

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingwithflows.server_data.final_result
import com.example.pagingwithflows.server_data.result
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class Viewmodel(retroInstance: RetroInstance) :ViewModel(){

    var result= MutableStateFlow<PagingData<result>>(PagingData.empty())
    var result1=result
    var repo=repo(retroInstance)


    fun getdata(){
        viewModelScope.launch {
            repo.getdata().collect {data->


                result.value=data
                Log.d("data","$data")
            }
        }

    }
}