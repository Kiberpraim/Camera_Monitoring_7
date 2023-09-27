package com.geeks.camera_monitoring_7.presentation.ui.fragment.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.geeks.camera_monitoring_7.data.dtos.DoorDto
import com.geeks.camera_monitoring_7.databinding.ItemDoorBinding

class DoorsAdapter(
//    private val onItemClick: () -> Unit
) : Adapter<DoorsAdapter.DoorsViewHolder>() {

    private var list: List<DoorDto> = listOf()

    fun setList(newList: List<DoorDto>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoorsViewHolder {
        return DoorsViewHolder(
            ItemDoorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DoorsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class DoorsViewHolder(private val binding: ItemDoorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(door: DoorDto) {
            with(binding) {
                tvTitle.text = door.name

                if (door.image != "") {
                    ivImage.load(door.image)
                    ivImage.visibility = View.VISIBLE
                    if (door.favorites) {
                        icStar.visibility = View.VISIBLE
                        icStarInTv.visibility = View.GONE
                    } else {
                        icStar.visibility = View.GONE
                    }
                } else if (door.favorites) {
                    icStar.visibility = View.GONE
                    icStarInTv.visibility = View.VISIBLE
                } else {
                    icStar.visibility = View.GONE
                    icStarInTv.visibility = View.GONE
                }
            }
            itemView.setOnClickListener {
//                onItemClick()
            }
        }
    }
}