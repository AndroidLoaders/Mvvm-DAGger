package com.example.mvvm_dagger.base.extensions.rx.rxview

import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import com.example.mvvm_dagger.base.extensions.rx.RxConstants
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

fun View.throttleClicks(): Observable<Unit> = clicks()
    .throttleLatest(
        RxConstants.TIME_DURATION_MEDIUM, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()
    )

fun AppCompatEditText.onTextChanges(onNext: (text: CharSequence) -> Unit): Disposable =
    textChanges().throttleLatest(
        RxConstants.TIME_DURATION_MEDIUM, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()
    ).subscribe(onNext)
