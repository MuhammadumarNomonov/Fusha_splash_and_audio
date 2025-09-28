package com.example.fusha.mad_chozish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fusha.databinding.Itemmydata2MadBinding
import com.example.fusha.databinding.MydataChozishBinding
class Adapter2(
    private val dataList: List<MyData2>,
    private val onItemClick: (MyData2, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_RED = 0   // Mad darslari
        private const val TYPE_PINK = 1  // Tashdid darslari
        private const val MAD_COUNT = 5  // Mad bo‘limi itemlari soni
        private const val TASHDID_COUNT = 3 // Tashdid bo‘limi itemlari soni
    }

    inner class GreenViewHolder(val binding: MydataChozishBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyData2, position: Int) {
            binding.lessontitle.text = item.title

            val isFirst = position == 0
            val isLast = position == MAD_COUNT - 1

            binding.chline.visibility = if (isFirst) View.GONE else View.VISIBLE
            binding.timeChline.visibility = if (isLast) View.GONE else View.VISIBLE
        }
    }

    inner class PinkViewHolder(val binding: Itemmydata2MadBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyData2, position: Int) {
            binding.lessontitle.text = item.title

            val relativePos = position - MAD_COUNT
            val isFirst = relativePos == 0
            val isLast = relativePos == TASHDID_COUNT - 1

            binding.time2.visibility = if (isFirst) View.GONE else View.VISIBLE
            binding.timelineLine.visibility = if (isLast) View.GONE else View.VISIBLE
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return if (position < MAD_COUNT) TYPE_RED else TYPE_PINK
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_RED -> GreenViewHolder(MydataChozishBinding.inflate(inflater, parent, false))
            TYPE_PINK -> PinkViewHolder(Itemmydata2MadBinding.inflate(inflater, parent, false))
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList.getOrNull(position) ?: return

        when (holder) {
            is GreenViewHolder -> holder.bind(item, position)
            is PinkViewHolder -> holder.bind(item, position)
        }

        holder.itemView.setOnClickListener {
            onItemClick(item, position)
        }
    }
}
