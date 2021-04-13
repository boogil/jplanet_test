package com.gilly.jplanettest.core.extension

import android.widget.Button
import android.widget.TextView
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


fun <T> Single<T>.onMainThread(): Single<T> = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.onEfficientThread(): Single<T> = subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())

