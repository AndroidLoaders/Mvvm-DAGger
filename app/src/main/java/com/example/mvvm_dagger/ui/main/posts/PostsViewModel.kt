package com.example.mvvm_dagger.ui.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.mvvm_dagger.base.extensions.rx.autoDispose
import com.example.mvvm_dagger.datamanager.DataManager
import com.example.mvvm_dagger.models.Post
import com.example.mvvm_dagger.networkadapter.SessionManager
import com.example.mvvm_dagger.ui.auth.Resource
import com.example.mvvm_dagger.ui.base.BaseViewModel
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val dataManager: DataManager, private val sessionManager: SessionManager
) : BaseViewModel() {

    private val TAG: String = "TAG --- ${PostsViewModel::class.java.simpleName} --->"

    private val posts: MediatorLiveData<Resource<List<Post>>> by lazy {
        MediatorLiveData<Resource<List<Post>>>()
    }

    fun observePostsList():LiveData<Resource<List<Post>>> = posts

    fun getPostsList() {
        if ((sessionManager.observeAuthUser().value != null) &&
            (sessionManager.observeAuthUser().value!!.data != null)
        ) {
            dataManager.getPosts(
                sessionManager.observeAuthUser().value!!.data!!.getUserId().toInt()
            ).doOnSubscribe { posts.value = Resource.loading() }
                .doOnSuccess { posts.value = Resource.success(it) }
                .doOnError { posts.value = it.message?.let { message -> Resource.error(message) } }
                .subscribe({

                }, {
                    println("$TAG ${it.message}")
                }).autoDispose(disposables)
        }
    }

    /*fun observePostsState(): LiveData<Resource<List<Post>>> {
        //if (posts.value == null) {
        posts.value = Resource.loading()
        if ((sessionManager.observeAuthUser().value != null)
            && (sessionManager.observeAuthUser().value!!.data != null)
        ) {
            val source: LiveData<Resource<List<Post>>> = LiveDataReactiveStreams.fromPublisher {
                dataManager.getPosts(
                    sessionManager.observeAuthUser().value!!.data!!.getUserId().toInt()
                ).onErrorReturn {
                    println("$TAG ${it.message}")
                    val post = Post()
                    val listPost: MutableList<Post> = mutableListOf()
                    listPost.add(post)
                    listPost
                }.map(object : Function<List<Post>, Resource<List<Post>>?> {
                    override fun apply(listPost: List<Post>): Resource<List<Post>>? {
                        val post = listPost[0]
                        if (post.getId() == "")
                            return Resource.error("Something went wrong")
                        return Resource.success(listPost)
                    }
                }).subscribeOn(Schedulers.io())
            }

            posts.addSource(source) {
                posts.value = it
                posts.removeSource(source)
            }
        } else
            posts.value = Resource.error("")
        return posts
    }*/
}