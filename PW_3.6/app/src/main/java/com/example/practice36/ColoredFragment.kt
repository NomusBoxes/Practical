package com.example.practice36

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.practice36.databinding.FragmentColorListBinding
import com.example.practice36.databinding.FragmentColoredBinding

class ColoredFragment : Fragment() {
    lateinit var binding : FragmentColoredBinding
    val viewModel: ViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_colored, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColoredBinding.bind(view)
        viewModel.colorId.observe(viewLifecycleOwner, {
            binding.apply {
                textColor.setBackgroundColor(it.colorId)
                textColor.text = it.colorName
            }
        })
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            ColoredFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}