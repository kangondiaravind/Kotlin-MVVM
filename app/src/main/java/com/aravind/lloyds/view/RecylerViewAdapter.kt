package com.aravind.lloyds.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aravind.lloyds.R
import com.aravind.lloyds.model.Item
import com.squareup.picasso.Picasso

/**
 * Recyler view adapter
 *
 * Create Recyler view adapter
 */
class RecylerViewAdapter : RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder>() {

    private var listData: List<Item>? = null

    /**
     * Set updated data
     *
     * @param items
     */
    fun setUpdatedData(listData: List<Item>?) {
        this.listData = listData
    }

    /**
     * My view holder
     *
     * @constructor
     *
     * @param itemView
     */
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageDisplay = itemView.findViewById<ImageView>(R.id.imageDispay)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvDesc = itemView.findViewById<TextView>(R.id.tvDesc)

        /**
         * Bind
         *
         * @param data
         */
        fun bind(data: Item) {
            tvTitle.text = data.name
            tvDesc.text = data.description
            val url = data.owner.avatar_url

            Picasso.get().load(url).into(imageDisplay)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0
        return listData?.size!!
    }
}