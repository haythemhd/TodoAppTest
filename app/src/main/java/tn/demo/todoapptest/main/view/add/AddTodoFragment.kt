package tn.demo.todoapptest.main.view.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tn.demo.todoapptest.R
import tn.demo.todoapptest.databinding.FragmentAddTodoBinding
import tn.demo.todoapptest.main.model.Todo

class AddTodoFragment : Fragment() {

    private val viewModel: AddViewModel by viewModels()
    private lateinit var binding: FragmentAddTodoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTodoBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        viewModel.result.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(requireContext(), R.string.success_add, Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.addBtn.setOnClickListener {
            GlobalScope.launch {
                viewModel.addTodo(
                    Todo(
                        memo = binding.tvMemo.text.toString(),
                        description = binding.tvDescription.text.toString(),
                        priority = binding.tvPriority.text.toString().toInt()
                    )
                )
            }
        }
    }

}