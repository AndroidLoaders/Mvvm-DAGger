package com.example.mvvm_dagger.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.models.Post
import kotlinx.android.synthetic.main.list_item_post_list.view.*
import javax.inject.Inject

class PostsListAdapters @Inject constructor() :
    RecyclerView.Adapter<PostsListAdapters.PostsViewHolder>() {

    private val postList: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val customView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_post_list, parent, false)
        return PostsViewHolder(customView)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) =
        holder.bindData(postList[position])

    fun setData(listPost: List<Post>) {
        this.postList.addAll(listPost)
        notifyDataSetChanged()
    }

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.tvTitle
        private val tvDescription: TextView = itemView.tvDescription

        fun bindData(post: Post) {
            tvTitle.text = post.getTitle()
            tvDescription.text = post.getBody()
        }
    }
}