package com.example.todolistapp.presentation.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.OneTodoBinding
import com.example.todolistapp.presentation.models.ToDoItemList


class RcToDosAdapter(
    val deleteBtClick: (ToDoItemList) -> Unit,
    val itemClick: (ToDoItemList) -> Unit
): RecyclerView.Adapter<RcToDosAdapter.RcToDosViewHolder>() {

    inner class RcToDosViewHolder(
        val binding: OneTodoBinding
    ): RecyclerView.ViewHolder(binding.root)




    val util = object: DiffUtil.ItemCallback<ToDoItemList>(){
        override fun areItemsTheSame(oldItem: ToDoItemList, newItem: ToDoItemList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDoItemList, newItem: ToDoItemList): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, util)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcToDosViewHolder {
        val view = OneTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RcToDosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RcToDosViewHolder, position: Int) {
        val currentitem = differ.currentList[position]
        with(holder.binding){
            tvid.text = "id: ${currentitem.id}"
            tvtodo.text = currentitem.title.toString()

            btDelete.setOnClickListener {
                deleteBtClick.invoke(currentitem)
            }
        }

        holder.itemView.setOnClickListener {
            itemClick.invoke(currentitem)
        }


    }



}