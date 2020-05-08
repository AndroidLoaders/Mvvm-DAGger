package com.example.mvvm_dagger.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_dagger.R
import dagger.android.support.DaggerFragment

class PostsFragment : DaggerFragment() {

    private val TAG: String = "TAG --- $Tag --->"

    companion object {
        val Tag: String = PostsFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_posts, container, false)
}