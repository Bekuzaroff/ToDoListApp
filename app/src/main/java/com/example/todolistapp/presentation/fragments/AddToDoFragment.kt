package com.example.todolistapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAddToDoBinding
import com.example.todolistapp.presentation.models.ToDoItemList
import com.example.todolistapp.presentation.viewmodels.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddToDoFragment : Fragment() {

    private lateinit var binding: FragmentAddToDoBinding

    private val viewModel: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddToDoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btaddtodo.setOnClickListener {
                val title = edtitle.text.toString()
                val desc = eddesc.text.toString()

                if(title.isEmpty()){
                    toast_msg("your title is empty, please fill it", requireContext())
                } else{
                    val item = ToDoItemList(title = title, description = desc)

                    viewModel.addToDo(item)

                    findNavController().navigate(R.id.action_addToDoFragment_to_listFragment)
                }



            }
        }
    }


    private fun toast_msg(msg: String = "", context: Context){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}