package com.example.todolistapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentUpdateToDoBinding
import com.example.todolistapp.presentation.models.ToDoItemList
import com.example.todolistapp.presentation.viewmodels.ToDoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateToDoFragment : Fragment() {

    private lateinit var binding: FragmentUpdateToDoBinding

    private val args: UpdateToDoFragmentArgs by navArgs()

    private val vm: ToDoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateToDoBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            edtitleUpdate.setText(args.item.title)
            eddescUpdate.setText(args.item.description)

            btupdateTodo.setOnClickListener {
                if (edtitleUpdate.text.isNotEmpty()) {
                    val new_item = ToDoItemList(id = args.item.id,title = edtitleUpdate.text.toString(),
                        description = eddescUpdate.text.toString())
                    vm.updateToDo(new_item)
                    findNavController().navigate(R.id.action_updateToDoFragment_to_listFragment)
                }else{
                    Toast.makeText(requireContext(), "sorry but your title is empty", Toast.LENGTH_LONG).show()
                }
            }
        }



    }
}