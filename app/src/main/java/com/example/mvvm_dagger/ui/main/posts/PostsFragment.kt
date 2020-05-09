package com.example.mvvm_dagger.ui.main.posts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.adapters.PostsListAdapters
import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject

class PostsFragment : DaggerFragment() {

    private val TAG: String = "TAG --- $Tag --->"

    companion object {
        val Tag: String = PostsFragment::class.java.simpleName
    }

    @Inject
    internal lateinit var viewModel: PostsViewModel

    @Inject
    internal lateinit var adapter: PostsListAdapters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_posts, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList.adapter = adapter

        viewModel.observePostsList().removeObservers(viewLifecycleOwner)
        viewModel.observePostsList().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResponseStatus.Loading -> loaderVisibility(View.VISIBLE)
                ResponseStatus.Success -> {
                    loaderVisibility(View.GONE)
                    it.data?.let { data -> adapter.setData(data) }
                }
                ResponseStatus.Error -> {
                    loaderVisibility(View.GONE)
                }
            }
        })

        viewModel.getPostsList()
    }

    private fun loaderVisibility(isVisible: Int) {
        progressBar.visibility = isVisible
    }
}