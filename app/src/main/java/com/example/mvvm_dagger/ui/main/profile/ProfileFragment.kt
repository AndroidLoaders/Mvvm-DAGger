package com.example.mvvm_dagger.ui.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mvvm_dagger.R
import com.example.mvvm_dagger.networkadapter.api.response.ResponseStatus
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject

class ProfileFragment : DaggerFragment() {

    private val TAG: String = "TAG --- $Tag --->"

    companion object {
        val Tag: String = ProfileFragment::class.java.simpleName
    }

    @Inject
    internal lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeStreams()
    }

    private fun subscribeStreams() {
        viewModel.observeAuthenticatedUser().removeObservers(viewLifecycleOwner)
        viewModel.observeAuthenticatedUser().observe(viewLifecycleOwner, Observer {
            it?.run {
                when (it.status) {
                    ResponseStatus.Success -> {
                        it.data?.let { user ->
                            tvEmail.text = user.getEmailId()
                            tvUsername.text = user.getUserName()
                            tvWebsite.text = user.getWebsite()
                        }
                    }
                    ResponseStatus.Error -> {

                    }
                    else->{}
                }
            }
        })
    }
}