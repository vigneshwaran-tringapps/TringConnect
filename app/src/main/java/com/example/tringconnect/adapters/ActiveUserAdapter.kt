package com.example.tringconnect.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tringconnect.R
import com.example.tringconnect.models.Users
import de.hdodenhof.circleimageview.CircleImageView

class ActiveUserAdapter: RecyclerView.Adapter<ActiveUserAdapter.UserViewHolder>(){



    private var items: List<Users> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.active_users, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        when(holder) {

            is UserViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(user: List<Users>){
        items = user
    }
    class UserViewHolder
    constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        val user_name = itemView.findViewById<TextView>(R.id.activeUsername)
        val user_img = itemView.findViewById<CircleImageView>(R.id.imageView)


        fun bind(user: Users){
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)


            user_name.setText(user.userName)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(user.userImg)
                .into(user_img)
        }

    }
}