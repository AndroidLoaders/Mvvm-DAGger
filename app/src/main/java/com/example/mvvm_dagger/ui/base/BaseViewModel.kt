package com.example.mvvm_dagger.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

open class BaseViewModel : ViewModel() {

    private val TAG: String = "TAG --- ${BaseViewModel::class.java.simpleName} --->"

    protected val disposables: CompositeDisposable = CompositeDisposable()
    protected val isLoading: PublishSubject<Boolean> = PublishSubject.create()
    protected val isError: PublishSubject<Throwable> = PublishSubject.create()

    override fun onCleared() {
        if ((disposables.size() > 0) && !disposables.isDisposed) {
            try {
                disposables.dispose()
                disposables.clear()
            } catch (e: Exception) {
                println("$TAG ${e.message}")
            }
        }
        super.onCleared()
    }
}