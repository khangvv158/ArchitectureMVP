package com.example.architecturemvp.data.source

import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.data.source.remote.OnFetchDataJsonListener

interface UserDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {

        fun getUsers(listener: OnFetchDataJsonListener<MutableList<User>>)
    }
}
