package com.gilly.jplanettest.presentation.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gilly.jplanettest.core.exception.Failure
import com.gilly.jplanettest.data.Commercial
import com.gilly.jplanettest.data.Company
import com.gilly.jplanettest.data.Review
import com.gilly.jplanettest.domain.repository.MainRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel : ViewModel() {
    protected val _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: LiveData<Failure> = _failure

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun addToDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
    protected fun handleFailure(failure: Failure?) {
        _failure.value = failure
    }
}