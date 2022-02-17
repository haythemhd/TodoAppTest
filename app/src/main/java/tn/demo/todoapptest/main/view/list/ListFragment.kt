package tn.demo.todoapptest.main.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.*
import tn.demo.todoapptest.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ListFragmentBinding
    private lateinit var list: ListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        initViews()
        setupObserver()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            viewModel.getListTodo()
        }
    }

    private fun setupObserver() {
        viewModel.list.observe(viewLifecycleOwner) {
            list.setItems(it)
        }
    }

    private fun initViews() {
        binding.floatingAddTodo.setOnClickListener {
            findNavController().navigate(ListFragmentDirections.actionNavListToNavAdd())
        }
        list = ListAdapter()
        binding.rvListTodos.adapter = list
        binding.rvListTodos.layoutManager = LinearLayoutManager(requireContext())
    }


}