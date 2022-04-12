package com.example.pagingwithflows

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingwithflows.server_data.final_result
import com.example.pagingwithflows.server_data.result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class repo(var retroInstance: RetroInstance) {

     fun getdata():Flow<PagingData<result>>{
        return Pager(config = PagingConfig(10,maxSize = 100),pagingSourceFactory = {pagingSource(retroInstance)}).flow
    }


}