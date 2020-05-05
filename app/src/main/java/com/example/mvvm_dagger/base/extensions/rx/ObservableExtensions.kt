package com.example.mvvm_dagger.base.extensions.rx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

// Observable Pattern
fun <T> Observable<T>.subscribeAndObserve(): Observable<T> = subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.subscribeAndObserve(
    onNext: (t: T) -> Unit, onError: (Throwable) -> Unit, onComplete: () -> Unit
): Disposable =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(onNext, onError, onComplete)

fun <T> Observable<T>.subscribeAndObserveWithDelaySubscription(): Observable<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .delaySubscription(RxConstants.DELAY_SUBSCRIPTION_MILLIS, TimeUnit.MILLISECONDS)

fun <T> Observable<T>.subscribeAndObserveWithDelaySubscription(
    onNext: (t: T) -> Unit, onError: (Throwable) -> Unit, onComplete: () -> Unit
): Disposable =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .delaySubscription(RxConstants.DELAY_SUBSCRIPTION_MILLIS, TimeUnit.MILLISECONDS)
        .subscribe(onNext, onError, onComplete)