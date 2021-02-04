package com.example.architecturemvp.data.source.remote.fetchjson

import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.data.model.UserEntity
import org.json.JSONObject

class ParseJson {

    fun userParseJson(jsonObject: JSONObject): User {
        return User(
            id = jsonObject.getString(UserEntity.ID),
            email = jsonObject.getString(UserEntity.EMAIL),
            firstName = jsonObject.getString(UserEntity.FIRST_NAME),
            lastName = jsonObject.getString(UserEntity.LAST_NAME),
            avatar = jsonObject.getString(UserEntity.AVATAR)
        )
    }
}
