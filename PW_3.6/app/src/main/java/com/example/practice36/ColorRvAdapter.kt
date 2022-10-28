package com.example.practice36

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStructure
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.practice36.databinding.FragmentColorListBinding
import com.example.practice36.databinding.OneIconBinding


class ColorRvAdapter(
    listArray:ArrayList<ColorInfo>,
    val listener: MyOnClickListener
) : RecyclerView.Adapter<ColorRvAdapter.ColorHolder>(){

    val colorList = listArray

    inner class ColorHolder(item : View) : RecyclerView.ViewHolder(item) {
        val binding = OneIconBinding.bind(item)//&&&&&&&&&&&&7

        init {
            itemView.setOnClickListener {
                listener.onClick(colorList[adapterPosition])
            }
        }

        fun bind(color : ColorInfo) = with(binding){
            textView.text = color.colorName
            root.setBackgroundColor(color.colorId)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.one_icon, parent, false)
        return ColorHolder(view)
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        holder.bind(colorList[position])
    }

    override fun getItemCount(): Int {
        return colorList.size
    }

    interface MyOnClickListener {
        fun onClick(color: ColorInfo)
    }
}