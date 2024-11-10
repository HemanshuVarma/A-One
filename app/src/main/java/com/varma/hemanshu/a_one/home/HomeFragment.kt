package com.varma.hemanshu.a_one.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.varma.hemanshu.a_one.R
import com.varma.hemanshu.a_one.adapter.UserListAdapter
import com.varma.hemanshu.a_one.databinding.FragmentHomeBinding
import com.varma.hemanshu.a_one.models.User

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var userAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        binding.rvUsers.layoutManager = LinearLayoutManager(context)
        userAdapter = UserListAdapter { userItem ->
            Log.d(TAG, "Item clicked: ${userItem.id}")
        }
        binding.rvUsers.adapter = userAdapter
        setObservers()
    }

    private fun setClickListeners() {
        /*binding.btnDetailScreen.setOnClickListener {
            Log.d(TAG, "Nav to detail screen")
            findNavController().navigate(R.id.action_home_to_details)
        }*/
    }

    private fun setObservers() {
        //Get data from ViewModel/Repo
        val usersList = mutableListOf(
            User(id = 1, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 2, name = "John", description = "SSE"),
            User(id = 3, name = "Hemanshu", description = "Software Engineer"),
            User(id = 4, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 5, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 6, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 7, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 8, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 9, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 10, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 11, name = "Hemanshu Varma", description = "Software Engineer"),
            User(id = 12, name = "Hemanshu Varma", description = "Software Engineer"),

            )
        userAdapter.submitList(usersList)
    }
}