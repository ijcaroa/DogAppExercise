package com.example.dogappexercise.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.dogappexercise.DogViewModel
import com.example.dogappexercise.R
import com.example.dogappexercise.databinding.FragmentFirstBinding
import java.util.*



class FirstFragment : Fragment() {
    private lateinit var binding : FragmentFirstBinding
    private val viewModel : DogViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFirstBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.livedataFromInternet.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                binding.textviewFirst.text = it.toString()
            }

        })


        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}