package com.example.pagingwithflows

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingwithflows.server_data.result
import kotlinx.android.synthetic.main.recyclerview_row.view.*

class adap():PagingDataAdapter<result,adap.myViewHolder>(diffUtilCallBack()) {

    inner class myViewHolder(var view: View):RecyclerView.ViewHolder(view){

        fun bind(item: result?) {

            itemView.tvName.text=item?.name
            itemView.tvDes.text=item?.species
            Glide.with(itemView.img)
                .load(item?.image)
                .circleCrop()
                .into(itemView.img)
            if(item?.id==20){
                itemView.visibility= View.GONE
            }


        }
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row,parent,false))
    }
    class diffUtilCallBack: DiffUtil.ItemCallback<result>(){
        override fun areItemsTheSame(oldItem: result, newItem: result): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: result, newItem: result):     Boolean {
            return (oldItem.name==newItem.name && oldItem.species==newItem.species)
        }

    }
}