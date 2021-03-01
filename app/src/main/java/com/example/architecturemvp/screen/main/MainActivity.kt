package com.example.architecturemvp.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.architecturemvp.R
import com.example.architecturemvp.data.model.User
import com.example.architecturemvp.data.source.UserRepository
import com.example.architecturemvp.screen.adapter.MainAdapter
import com.example.architecturemvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<User> {

    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        with(recyclerViewUser) {
            setHasFixedSize(true)
            adapter = this@MainActivity.adapter
        }
        adapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        val presenter = MainPresenter(UserRepository.instance).run {
            setView(this@MainActivity)
            getUsers()
        }
    }

    override fun onGetUsersSuccess(users: MutableList<User>) {
        adapter.updateData(users)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: User?) {
        Toast.makeText(this, item?.lastName, Toast.LENGTH_SHORT).show()
    }
}
