package com.example.tringconnect.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tringconnect.R
import com.example.tringconnect.adapters.ActiveUserAdapter
import com.example.tringconnect.adapters.CourseAdapter
import com.example.tringconnect.adapters.PostAdapter
import com.example.tringconnect.models.Course
import com.example.tringconnect.models.Users
import com.example.tringconnect.models.blogPost


class SharedPostFragment:Fragment() {
    private lateinit var blogAdapter: PostAdapter
    private lateinit var userAdapter: ActiveUserAdapter
    private lateinit var courseAdapter: CourseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_postview, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        initRecyclerView(view)
        addDataSet()
    }
    private fun addDataSet(){

        val list = ArrayList<blogPost>()
        var user_list = ArrayList<Users>()
        var cousre_list = ArrayList<Course>()
        list.add(
            blogPost(
                1,
                "John Mathis",
                "Product delivery manager",
                R.drawable.avatar,
                "Successfully delivered this great kitchen app to market. kudos to the entire team",
                "#network #kitchenapp #foodie #productdesign...",
                R.drawable.post_image
            )
        )
        list.add(
            blogPost(
                2,
                "Joel Rhodes",
                "Director marketing sales",
                R.drawable.profile_avatar,
                "Good marketing makes the company look smart. Great marketing makes customer feel smart.   ",
                "#marketing #sales #Strategy #businessgoal #di…",
                R.drawable.collage
            )
        )

        list.add(
            blogPost(
                3,
                "Landon Murray",
                "Creative Director",
                R.drawable.avatar,
                "Design is all about, using your brain 100%",
                "#Creative design #Brainstroming #UX/Ui #Rese… ",
                R.drawable.post_image3
            )
        )

        list.add(
            blogPost(
                4,
                "Tringapps",
                "Management",
                R.drawable.profile_avatar,
                "tringapps is now an AWS partner.",
                "#management #tringers #tringapps #AWS #am…",
                R.drawable.banner
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask,
            "HR Team"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask1,
                "Creative Bees"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask3,
                "TechmMads"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask1,
                "Cloud 9"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask3,
                "Mr Beast"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask,
                "Yes Theory"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask3,
                "Unibeacon"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask3,
                "Xmen"
            )
        )
        user_list.add(
            Users(
                R.drawable.image_mask3,
                "BatCave"
            )
        )


        cousre_list.add(
            Course(
                R.drawable.course1,
                "AWS Dynamo DB"
            )
        )
        cousre_list.add(
            Course(
                R.drawable.course2,
                "Portfolio Management"
            )
        )
        userAdapter.submitList(user_list)
        blogAdapter.submitList(list)
    }

    private fun initRecyclerView(view: View){
        val recycler_view = view.findViewById<RecyclerView>(R.id.recyclerview)
        val recycler_view_hor = view.findViewById<RecyclerView>(R.id.usersList)
        val recycler_view_hor_course = view.findViewById<RecyclerView>(R.id.courseList)

        userAdapter = ActiveUserAdapter()
        blogAdapter = PostAdapter()
        courseAdapter = CourseAdapter()

        recycler_view_hor.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        }
        recycler_view.apply {

            adapter = blogAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        recycler_view_hor_course.apply {

            adapter = courseAdapter
            layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        }

    }

}