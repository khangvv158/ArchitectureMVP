@file:Suppress("DEPRECATION")

package com.example.architecturemvp.data.source.remote

import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.data.model.UserEntity
import com.example.architecturemvp.data.source.UserDataSource
import com.example.architecturemvp.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.architecturemvp.utils.Constant

class UserRemoteDataSource : UserDataSource.Remote {

    private var baseUrl = Constant.BASE_URL

    private object Holder {
        val INSTANCE = UserRemoteDataSource()
    }

    override fun getUsers(listener: OnFetchDataJsonListener<MutableList<User>>) {
        GetJsonFromUrl(listener, UserEntity.USER).execute(baseUrl + Constant.BASE_PAGE)
    }

    companion object {
        val instance: UserRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
