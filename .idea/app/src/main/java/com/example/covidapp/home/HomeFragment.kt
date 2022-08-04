package com.example.covidapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.example.covidapp.R
import com.example.covidapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeAdapter by lazy { HomeAdapter()}

    private val viewModel by lazy { HomeViewModel()}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter.onCountryItemClick = {
            viewModel.getStatistics()
        }
        viewModel.countryList.observe(viewLifecycleOwner){
            with(binding){
                recyclerview.adapter=homeAdapter
                swipeRefreshLayout.isRefreshing=false
            }
            homeAdapter.updateListCountry(it)
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getStatistics()
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchStatistics(query.orEmpty())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchStatistics(newText.orEmpty())
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}