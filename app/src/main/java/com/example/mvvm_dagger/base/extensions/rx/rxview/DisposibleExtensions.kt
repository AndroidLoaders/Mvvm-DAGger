package com.example.mvvm_dagger.base.extensions.rx.rxview

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.autoDispose(compositeDisposable: CompositeDisposable) = compositeDisposable.add(this)