package com.example.practice36

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice36.databinding.FragmentColorListBinding

class ColorListFragment : Fragment() , ColorRvAdapter.MyOnClickListener{

    lateinit var binding : FragmentColorListBinding
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
        return inflater.inflate(R.layout.fragment_color_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentColorListBinding.bind(view)
        init()
    }

    private fun init(){
        binding.apply {
//            viewModel = ViewModelProvider(this@ColorListFragment).get(ViewModel::class.java)

            val list = arrayListOf<ColorInfo>()
            list.addAll(fillArras(resources.getStringArray(R.array.colorNames),
                resources.getIntArray(R.array.colorValues)))

            colorListRv.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = ColorRvAdapter(list, this@ColorListFragment)
            }
//            colorListRv.layoutManager = LinearLayoutManager(activity)
//            val myAdapter = ColorRvAdapter(list)
//            colorListRv.adapter = myAdapter

        }
    }

    fun fillArras(nameArray: Array<String>, colorArray: IntArray) : List<ColorInfo>
    {
        val listItemArray = ArrayList<ColorInfo>()
        for(n in 0..colorArray.size - 1)
        {
            val listItem = ColorInfo(colorArray[n],nameArray[n])
            listItemArray.add(listItem)
        }

        return listItemArray
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ColorListFragment().apply {
                arguments = Bundle().apply {

                }
            }
            }

    override fun onClick(color: ColorInfo) {
            viewModel.colorId.value = color
    }
}