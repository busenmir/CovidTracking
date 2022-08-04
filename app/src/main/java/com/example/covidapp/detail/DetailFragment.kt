package com.example.covidapp.detail

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.covidapp.R
import com.example.covidapp.databinding.FragmentDetailBinding
import com.example.covidapp.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy { DetailViewModel()}

    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = args.detail
        binding.apply {
            statisticModel = model
            historyButton.setOnClickListener{
                val action = DetailFragmentDirections.actionDetailFragmentToHistoryFragment()
                findNavController().navigate(action)
            }
            staticsButton.setOnClickListener {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(
                    Intent.EXTRA_TEXT,
                    "Statics Data : ${statisticModel}"
                )
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}