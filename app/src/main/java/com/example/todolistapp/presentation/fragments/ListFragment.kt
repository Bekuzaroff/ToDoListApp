package com.example.todolistapp.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentListBinding
import com.example.todolistapp.presentation.adapters.RcToDosAdapter
import com.example.todolistapp.presentation.models.ToDoItemList
import com.example.todolistapp.presentation.viewmodels.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val toDoViewModel: ToDoViewModel by viewModels()

    var adapter: RcToDosAdapter = RcToDosAdapter(
        {item ->
            deleteBtClickAdapter(item)
        },
        {item ->
            itemClickAdapter(item)
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //get from db
        toDoViewModel.getAllToDos()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){
            //TODO init
            rcTodos.adapter = adapter
            rcTodos.layoutManager = LinearLayoutManager(requireContext())



            //TODO navigation
            btAddTodo.setOnClickListener {
                findNavController().navigate(R.id.action_listFragment_to_addToDoFragment)
            }

            //TODO DATABASE OPERATIONS
            lifecycleScope.launch {
                toDoViewModel.all_todos.collect{list ->
                    adapter.differ.submitList(list)
                }
            }
        }





    }

    private fun deleteBtClickAdapter(toDoItemList: ToDoItemList){
        toDoViewModel.deleteToDo(toDoItemList)
        toDoViewModel.getAllToDos()
    }

    private fun itemClickAdapter(toDoItemList: ToDoItemList){
        val directions = ListFragmentDirections.actionListFragmentToUpdateToDoFragment(toDoItemList)
        findNavController().navigate(directions)
    }

















}