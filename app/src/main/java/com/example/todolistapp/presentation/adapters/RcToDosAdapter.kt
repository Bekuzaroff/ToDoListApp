package com.example.todolistapp.presentation.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.OneTodoBinding
import com.example.todolistapp.presentation.models.ToDoItemList


class RcToDosAdapter(
    val deleteBtClick: (ToDoItemList) -> Unit,
    val itemClick: (ToDoItemList) -> Unit
): RecyclerView.Adapter<RcToDosAdapter.RcToDosViewHolder>() {
    var list: List<ToDoItemList> = listOf()

    inner class RcToDosViewHolder(
        val binding: OneTodoBinding
    ): RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcToDosViewHolder {
        val view = OneTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RcToDosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RcToDosViewHolder, position: Int) {
        with(holder.binding){
            tvid.text = "in queue: ${position + 1}"
            tvtodo.text = list[position].title

            btDelete.setOnClickListener {
                Log.d("tagg", position.toString())
                deleteBtClick.invoke(list[position])

            }
        }

        holder.itemView.setOnClickListener {
            itemClick.invoke(list[position])
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    fun newList(new_list: List<ToDoItemList>){
        list = new_list
        notifyDataSetChanged()
    }

}