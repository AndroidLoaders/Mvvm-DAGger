package com.example.mvvm_dagger.viewmodelproviderfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor(
    private val vmCreator: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    private val TAG: String = "TAG --- ${ViewModelProviderFactory::class.java.simpleName} --->"

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val vmProvider: Provider<ViewModel>? = vmCreator[modelClass]
        try {
            if (vmProvider == null) {
                vmCreator.forEach {
                    if (modelClass.isAssignableFrom(it.key))
                        return it.value.get() as T
                }
            }

            if (vmProvider == null) {
                println("$TAG IllegalArgumentException Generated")
                throw IllegalArgumentException("Please check your ViewModel Class")
            }

            return vmProvider.get() as T
        } catch (e: Exception) {
            println("$TAG ${e.message}")
            throw RuntimeException("Please check your ViewModel Class", e)
        }
    }
}