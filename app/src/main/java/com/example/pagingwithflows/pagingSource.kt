package com.example.pagingwithflows

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingwithflows.server_data.result

class pagingSource( var retroInstance: RetroInstance):PagingSource<Int,result>() {
    override fun getRefreshKey(state: PagingState<Int, result>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, result> {
        var current=params.key?:1
        var res=retroInstance.getData(current)

        Log.d("datai","${retroInstance.getData(current)}")
        var prev=if(current==1) null else current-1
        return LoadResult.Page(retroInstance.getData(current).results!!,prevKey =prev,nextKey = if(false) null else current+1)

    }
}