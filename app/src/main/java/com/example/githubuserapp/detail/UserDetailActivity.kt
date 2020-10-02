package com.example.githubuserapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuserapp.R
import com.example.githubuserapp.databinding.ActivityUserDetailBinding
import com.example.githubuserapp.model.GithubUser

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val GITHUB_USER_DATA: String = "user_data"
    }

    private lateinit var mBinding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        val githubUser = intent.getParcelableExtra<GithubUser>(GITHUB_USER_DATA)
        mBinding.user = githubUser
        Glide.with(this)
            .load(githubUser?.avatar)
            .apply(RequestOptions.errorOf(R.drawable.ic_person))
            .into(mBinding.civAvatar)
    }
}