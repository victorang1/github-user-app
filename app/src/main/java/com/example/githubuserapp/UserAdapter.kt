package com.example.githubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuserapp.databinding.UserDetailItemLayoutBinding
import com.example.githubuserapp.model.GithubUser

class UserAdapter(private val context: Context, private var userList: List<GithubUser>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserDetailItemLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val githubUser = userList[position]
        holder.bind(githubUser)
    }

    override fun getItemCount(): Int = userList.count()

    fun setDataSet(userList: List<GithubUser>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val itemBinding: UserDetailItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(githubUser: GithubUser) {
            itemBinding.user = githubUser
            Glide.with(context)
                .load(githubUser.avatar)
                .apply(RequestOptions.errorOf(R.drawable.ic_person))
                .into(itemBinding.civAvatar)
        }
    }
}