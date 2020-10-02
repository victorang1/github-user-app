package com.example.githubuserapp

import com.example.githubuserapp.model.GithubUser

interface IUserAction {

    fun onItemClick(user: GithubUser)
}