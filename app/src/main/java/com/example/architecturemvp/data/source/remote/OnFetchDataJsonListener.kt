package com.example.architecturemvp.data.source.remote

import java.lang.Exception

interface OnFetchDataJsonListener<T> {

    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
