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

class CourseAdapter: RecyclerView.Adapter<CourseAdapter.CourseViewHolder>(){



    private var items: List<Users> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cource_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        when(holder) {

            is CourseViewHolder -> {
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
    class CourseViewHolder
    constructor(itemView: View): RecyclerView.ViewHolder(itemView){

        val course_name = itemView.findViewById<TextView>(R.id.cousreName)
        val course_img = itemView.findViewById<CircleImageView>(R.id.courseImage)


        fun bind(user: Users){
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)


            course_name.setText(user.userName)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(user.userImg)
                .into(course_img)
        }

    }
}