package com.example.app_common.utils

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.ptSchedulers(): Observable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}