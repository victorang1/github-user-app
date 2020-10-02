package com.example.githubuserapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubuserapp.databinding.ActivityMainBinding
import com.example.githubuserapp.model.GithubUser

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: UserAdapter

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        prepareDataSet()
        initializeAdapter()
        initializeDataSet()
    }

    private fun initializeAdapter() {
        mAdapter = UserAdapter(this, arrayListOf())
        val layoutManager = LinearLayoutManager(this)
        mBinding.rvUser.layoutManager = layoutManager
        mBinding.rvUser.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        mBinding.rvUser.adapter = mAdapter
    }

    private fun prepareDataSet() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
    }

    private fun initializeDataSet() {
        val list = mutableListOf<GithubUser>()
        for (position in resources.getStringArray(R.array.username).indices) {
            list.add(
                GithubUser(
                    dataUsername[position],
                    dataName[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataCompany[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataAvatar.getResourceId(position, -1)
                )
            )
        }
        mAdapter.setDataSet(list)
    }
}