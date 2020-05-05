package com.example.mvvm_dagger.base.extensions.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

// Single Observable Pattern
fun <T> Single<T>.subscribeAndObserve(): Single<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.subscribeAndObserve(onSuccess: (t: T) -> Unit, onError: (Throwable) -> Unit):
        Disposable =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(onSuccess, onError)

fun <T> Single<T>.subscribeAndObserveWithDelaySubscription(): Single<T> =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .delaySubscription(RxConstants.DELAY_SUBSCRIPTION_MILLIS, TimeUnit.MILLISECONDS)

fun <T> Single<T>.subscribeAndObserveWithDelaySubscription(
    onSuccess: (t: T) -> Unit, onError: (Throwable) -> Unit
): Disposable =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .delaySubscription(RxConstants.DELAY_SUBSCRIPTION_MILLIS, TimeUnit.MILLISECONDS)
        .subscribe(onSuccess, onError)