package com.example.pagingwithflows

data class  Response<out T>(var status: Status, val data:T?, var msg:String?){
    companion object{
        fun <T> success(data:T?):Response<T>{
            return Response(Status.SUCCESS,data,"")
        }

        fun <T> fail(msg:String):Response<T>{
            return Response(Status.ERROR,null,msg)
        }
        fun <T> loading():Response<T>{
            return Response(Status.LOADING,null,null)
        }
    }
}
