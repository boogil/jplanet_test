package com.gilly.jplanettest.presentation.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gilly.jplanettest.core.exception.Failure
import com.gilly.jplanettest.core.extension.onEfficientThread
import com.gilly.jplanettest.data.CellType
import com.gilly.jplanettest.data.Commercial
import com.gilly.jplanettest.data.Company
import com.gilly.jplanettest.data.Review
import com.gilly.jplanettest.domain.repository.MainRepository

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    val _companys: MutableLiveData<ArrayList<Company>> = MutableLiveData()
    val _commercials: MutableLiveData<ArrayList<Commercial>> = MutableLiveData()
    val _reviews: MutableLiveData<ArrayList<Review>> = MutableLiveData()
    val _items: MutableLiveData<MutableList<CellType?>> = MutableLiveData()

    val companys: LiveData<ArrayList<Company>> = _companys
    val commercials: LiveData<ArrayList<Commercial>> = _commercials
    val reviews: LiveData<ArrayList<Review>> = _reviews
    val items: LiveData<MutableList<CellType?>> = _items

    fun getData() {
        addToDisposable(mainRepository.getData()
            .onEfficientThread()
            .subscribe(
                {
                    _companys.value = it.companys
                    _commercials.value = it.commercials
                    _reviews.value = it.reviews
                    _items.value = it.items
                },
                {
                    _failure.value = Failure.ServerFailure
                }
            ))
    }
}