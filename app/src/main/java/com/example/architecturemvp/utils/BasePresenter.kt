package com.example.architecturemvp.utils

interface BasePresenter<T> {

    fun onStart()
    fun onStop()
    fun setView(view: T?)
}
