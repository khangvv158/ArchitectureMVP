package com.example.architecturemvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecturemvp.R
import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_user.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val users = mutableListOf<User>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<User>? = null

    fun updateData(users: MutableList<User>?) {
        users?.let {
            this.users.clear()
            this.users.addAll(it)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<User>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_user, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(users[position])
    }

    override fun getItemCount() = users.size

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<User>?
    ) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<User>? = null

        fun bindViewData(user: User) {
            itemView.textViewName.text = "${user.lastName} ${user.firstName}"
            itemView.textViewEmail.text = user.email
            getImageCircle(user)
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        private fun getImageCircle(user: User) {
            Glide.with(itemView.context)
                .load(user.avatar)
                .into(itemView.imageAvatar)
        }

        override fun onClick(view: View?) {
            listener?.onItemClickListener(users[adapterPosition])
        }
    }
}
