package com.example.thedailystoic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuotesAdapter (private val values: List<String>) :
        RecyclerView.Adapter<QuotesAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.quote_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.quoteTextView?.text = values[position]
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quoteTextView: TextView? = null
        var smallTextView: TextView? = null

        init {
            quoteTextView = itemView?.findViewById(R.id.quote_textView)
            smallTextView = itemView?.findViewById(R.id.small_textView)
        }
    }
}