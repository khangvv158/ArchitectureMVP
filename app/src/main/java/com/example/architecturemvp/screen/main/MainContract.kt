package com.example.architecturemvp.screen.main

import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.utils.BasePresenter

interface MainContract {
    /**
     * View
     */
    interface View {

        fun onGetUsersSuccess(users: MutableList<User>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {

        fun getUsers()
    }
}
