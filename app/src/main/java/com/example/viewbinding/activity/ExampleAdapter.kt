package com.example.viewbinding.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.databinding.ExampleAdapterBinding


class ExampleAdapter : ListAdapter<ViewBindingExampleModel, ExampleAdapter.RestaurantViewHolder>(RestaurantComparator()) {


    class RestaurantViewHolder(private val binding: ExampleAdapterBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(restaurant: ViewBindingExampleModel){
            binding.apply {
                txtExample.text = "ViewBinding Example"
            }
        }
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem  = getItem(position)
        if(currentItem != null){
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val binding = ExampleAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  RestaurantViewHolder(binding)
    }

    class RestaurantComparator: DiffUtil.ItemCallback<ViewBindingExampleModel>(){
        override fun areItemsTheSame(oldItem: ViewBindingExampleModel, newItem: ViewBindingExampleModel) = oldItem.name == newItem.name


        override fun areContentsTheSame(oldItem: ViewBindingExampleModel, newItem: ViewBindingExampleModel) =
            oldItem  == newItem

    }
}