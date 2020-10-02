package com.example.githubuserapp.model

import android.graphics.Bitmap
import android.os.Parcelable
import androidx.databinding.BaseObservable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val username: String,
    val name: String,
    val location: String,
    val repository: String,
    val company: String,
    val followers: Int,
    val following: Int,
    val avatar: Bitmap
) : BaseObservable(), Parcelable