package com.example.architecturemvp.data.source

import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.data.source.remote.OnFetchDataJsonListener
import com.example.architecturemvp.data.source.remote.UserRemoteDataSource

class UserRepository private constructor(
    private val remote: UserDataSource.Remote,
) {

    private object Holder {
        val INSTANCE = UserRepository(
            remote = UserRemoteDataSource.instance
        )
    }

    fun getUsers(listener: OnFetchDataJsonListener<MutableList<User>>) {
        remote.getUsers(listener)
    }

    companion object {
        val instance: UserRepository by lazy { Holder.INSTANCE }
    }
}
