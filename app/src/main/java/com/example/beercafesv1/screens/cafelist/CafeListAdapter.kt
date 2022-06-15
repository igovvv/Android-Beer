package com.example.beercafesv1.screens.cafelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.beercafesv1.models.BeerCafeItem
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.beercafesv1.databinding.CafeItemViewBinding
import com.example.beercafesv1.databinding.FragmentCafeBinding
import com.example.beercafesv1.databinding.FragmentCafeListBinding
import okhttp3.Response

class CafeListAdapter(val clickListener: BeerCafeClickListener) :
    ListAdapter<BeerCafeItem, CafeListAdapter.ViewHolder>(ToDoDiffCallback()){



    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {


        return ViewHolder(CafeItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
    class ViewHolder (private var binding: CafeItemViewBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(
            beerCafe: BeerCafeItem,
            clickListener: BeerCafeClickListener
        ) {
            binding.beerCafe = beerCafe
            binding.clickListener = clickListener

            binding.executePendingBindings()
        }

    }
}


class ToDoDiffCallback: DiffUtil.ItemCallback<BeerCafeItem>(){
    override fun areItemsTheSame(oldItem: BeerCafeItem, newItem: BeerCafeItem): Boolean {
        return oldItem.Name == newItem.Name
    }

    override fun areContentsTheSame(oldItem: BeerCafeItem, newItem: BeerCafeItem): Boolean {
        return oldItem == newItem
    }
}

class BeerCafeClickListener(val clickListener: (beerCafe: BeerCafeItem) -> Unit){
    fun onClick(beerCafe: BeerCafeItem) = clickListener(beerCafe)
}

