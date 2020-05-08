package com.example.mvvm_dagger.di.annotations

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * This is custom Annotation to bind ViewModel class as a Key and When
 * new Object of ViewModel class will be created because we know that
 * ViewModelProviderFactory class is accepting ViewModel class as a Key.
 * */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)