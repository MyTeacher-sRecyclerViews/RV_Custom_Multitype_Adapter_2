package com.example.rvcustommultitypeadapter_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvcustommultitypeadapter_2.R
import com.example.rvcustommultitypeadapter_2.model.Member

class CustomAdapter(var context: Context, val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES = 0
    private val TYPE_AVAILABLE_NO = 1

    override fun getItemViewType(position: Int): Int {
        return if (members[position].available) {
            TYPE_AVAILABLE_YES
        } else {
            TYPE_AVAILABLE_NO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_AVAILABLE_YES) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_available_layout, parent, false)
            return CustomViewYesHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_not_available_layout, parent, false)
        return CustomViewNoHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomViewYesHolder) {
            holder.firstName.text = member.name
            holder.lastName.text = member.lastName
        }
        if (holder is CustomViewNoHolder) {
            holder.firstName.setText(R.string.norec)
            holder.lastName.setText(R.string.not_ava)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    class CustomViewYesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tv_name)
        val lastName: TextView = itemView.findViewById(R.id.tv_last)
    }

    class CustomViewNoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName: TextView = itemView.findViewById(R.id.tv_name)
        val lastName: TextView = itemView.findViewById(R.id.tv_last)
    }
}