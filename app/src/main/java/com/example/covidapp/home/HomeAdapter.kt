package com.example.covidapp.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.covidapp.data.CaseModel
import com.example.covidapp.data.StatisticResponse
import com.example.covidapp.databinding.CovidItemBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.CountryViewHolder>() {
    var onCountryItemClick: (String) -> Unit = {}
    private val countryList = ArrayList<StatisticResponse>()
    inner class CountryViewHolder(private var binding: CovidItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(statistic: StatisticResponse) {
            itemClickListener(statistic)
            with(binding) {
                tvCountry.text = statistic.country
                tvTests.text = (statistic.tests?.total ?: 0).toString()
                tvCases.text = (statistic.cases?.total ?: 0).toString()
                tvDeaths.text = (statistic.deaths?.total ?: 0).toString()
            }
        }
        fun itemClickListener(item : StatisticResponse){
            binding.cardView.apply {
                setOnClickListener {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)
                    findNavController().navigate(action)
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CovidItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList[position])
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateListCountry(list: List<StatisticResponse>) {
        countryList.clear()
        countryList.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }
}