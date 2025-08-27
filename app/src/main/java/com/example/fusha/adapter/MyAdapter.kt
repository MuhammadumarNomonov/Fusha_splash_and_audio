package com.example.fusha.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
// import com.example.fusha.databinding.CustomHeader13Binding // <-- COMMENT
// import com.example.fusha.databinding.CustomHeader29Binding // <-- COMMENT
import com.example.fusha.databinding.ItemmydataBinding
// import com.example.fusha.databinding.Itemmydata2Binding // <-- COMMENT
// import com.example.fusha.databinding.Itemmydata3Binding // <-- COMMENT
import com.example.fusha.models.Mydata

class MyAdapter(
    private val dataList: List<Mydata>,
    private val onItemClick: (Mydata, Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_GREEN = 0
        // private const val TYPE_HEADER_13 = 1 // <-- COMMENT
        // private const val TYPE_PURPLE = 2 // <-- COMMENT
        // private const val TYPE_HEADER_29 = 3 // <-- COMMENT
        // private const val TYPE_PINK = 4 // <-- COMMENT

        // private const val HEADER_POSITION_13 = 34 // <-- COMMENT
        // private const val HEADER_POSITION_29 = 39 // <-- COMMENT
    }

    // inner class Header13ViewHolder(binding: CustomHeader13Binding) : // <-- COMMENT
    //     RecyclerView.ViewHolder(binding.root) // <-- COMMENT

    // inner class Header29ViewHolder(binding: CustomHeader29Binding) : // <-- COMMENT
    //     RecyclerView.ViewHolder(binding.root) // <-- COMMENT

    inner class GreenViewHolder(val binding: ItemmydataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Mydata) {
            binding.lessontitle.text = item.title
        }
    }

    // inner class PurpleViewHolder(val binding: Itemmydata2Binding) : // <-- COMMENT
    //     RecyclerView.ViewHolder(binding.root) { // <-- COMMENT
    //     fun bind(item: Mydata) { // <-- COMMENT
    //         binding.lessontitle.text = item.title // <-- COMMENT
    //     } // <-- COMMENT
    // } // <-- COMMENT

    // inner class PinkViewHolder(val binding: Itemmydata3Binding) : // <-- COMMENT
    //     RecyclerView.ViewHolder(binding.root) { // <-- COMMENT
    //     fun bind(item: Mydata) { // <-- COMMENT
    //         binding.lessontitle.text = item.title // <-- COMMENT
    //     } // <-- COMMENT
    // } // <-- COMMENT

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return TYPE_GREEN // <-- faqat GREEN qolgan
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_GREEN -> GreenViewHolder(ItemmydataBinding.inflate(inflater, parent, false))
            // TYPE_PURPLE -> PurpleViewHolder(Itemmydata2Binding.inflate(inflater, parent, false)) // <-- COMMENT
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList.getOrNull(position) ?: return

        when (holder) {
            is GreenViewHolder -> {
                holder.bind(item)
                val isFirst = position == 0
                val isLast = position == itemCount - 1
                holder.binding.time2.visibility = if (isFirst) View.GONE else View.VISIBLE
                holder.binding.timelineLine.visibility = if (isLast) View.GONE else View.VISIBLE
            }
            // is PurpleViewHolder -> { // <-- COMMENT
            //     holder.bind(item) // <-- COMMENT
            //     val isFirst = position == 0 // <-- COMMENT
            //     val isLast = position == itemCount - 1 // <-- COMMENT
            //     holder.binding.time2.visibility = if (isFirst) View.GONE else View.VISIBLE // <-- COMMENT
            //     holder.binding.timelineLine.visibility = if (isLast) View.GONE else View.VISIBLE // <-- COMMENT
            // } // <-- COMMENT
        }

        holder.itemView.setOnClickListener {
            onItemClick(item, position)
        }
    }
}
