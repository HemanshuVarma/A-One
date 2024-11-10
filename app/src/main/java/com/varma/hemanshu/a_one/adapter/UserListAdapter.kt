package com.varma.hemanshu.a_one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.varma.hemanshu.a_one.R
import com.varma.hemanshu.a_one.models.User

class UserListAdapter(private val onItemClick: (User) -> Unit) :
    ListAdapter<User, UserListAdapter.UserItemViewHolder>(UserItemDiffCallback()) {

    inner class UserItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(user: User) {
            titleTextView.text = user.name
            descriptionTextView.text = user.description
            itemView.setOnClickListener { onItemClick(user) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false)
        return UserItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class UserItemDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}