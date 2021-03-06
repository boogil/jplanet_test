package com.gilly.jplanettest.presentation.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
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
    private val _companys: MutableLiveData<ArrayList<Company>> = MutableLiveData()
    private val _commercials: MutableLiveData<ArrayList<Commercial>> = MutableLiveData()
    private val _reviews: MutableLiveData<ArrayList<Review>> = MutableLiveData()
    private val _cellTypes: MutableLiveData<ArrayList<CellType?>> = MutableLiveData()

    val companys: LiveData<ArrayList<Company>> = _companys
    val commercials: LiveData<ArrayList<Commercial>> = _commercials
    val reviews: LiveData<ArrayList<Review>> = _reviews
    val cellTypes: LiveData<ArrayList<CellType?>> = _cellTypes

    fun getData() {
        addToDisposable(mainRepository.getData()
            .onEfficientThread()
            .subscribe(
                {
                    _companys.value = it.companys
                    _commercials.value = it.commercials
                    _reviews.value = it.reviews
                    _cellTypes.value = it.cellTypes
                },
                {
                    _failure.value = Failure.NetworkFailure
                }
            ))
    }
}