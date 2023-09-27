package com.geeks.camera_monitoring_7.presentation.ui.fragment.cameras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import com.geeks.camera_monitoring_7.data.dtos.CameraDto
import com.geeks.camera_monitoring_7.databinding.ItemCameraBinding

class CamerasAdapter(
//    private val onItemClick: () -> Unit
) : Adapter<CamerasAdapter.CamerasViewHolder>() {

    private var list: List<CameraDto> = listOf()

    fun setList(newList: List<CameraDto>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CamerasViewHolder {
        return CamerasViewHolder(
            ItemCameraBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CamerasViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CamerasViewHolder(private val binding: ItemCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(camera: CameraDto) {
            with(binding) {
                ivImage.load(camera.image)
                tvTitle.text = camera.name
                if (camera.rec) {
                    icRec.visibility = View.VISIBLE
                } else {
                    icRec.visibility = View.GONE
                }
                if (camera.favorites) {
                    icStar.visibility = View.VISIBLE
                } else {
                    icStar.visibility = View.GONE
                }
            }
            itemView.setOnClickListener {
//                onItemClick()
            }
        }
    }
}