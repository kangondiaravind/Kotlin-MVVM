package com.aravind.lloyds.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aravind.lloyds.R
import com.aravind.lloyds.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Github repositories list fragment
 *
 * Create Github repositories list fragment
 */

@AndroidEntryPoint
class GithubRepositoriesListFragment : Fragment() {


    private lateinit var recylerViewAdapter: RecylerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("LOG", "Inside oncreate Fragment")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github_repositories_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recylerViewAdapter = RecylerViewAdapter()
        recyclerView.adapter = recylerViewAdapter
        initViewModel()
    }


    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getRecylerListObserver().observe(requireActivity(), Observer { items ->
            if (items != null) {
                recylerViewAdapter.setUpdatedData(items)
                recylerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "Error while fetching the response", Toast.LENGTH_SHORT)
                    .show();
            }
        })
        viewModel.loadListofData()
    }


}