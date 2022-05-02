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
import com.example.tringconnect.models.BlogPost


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

        val list = ArrayList<BlogPost>()
        var userList = ArrayList<Users>()
        var cousreList = ArrayList<Course>()
        list.add(
            BlogPost(
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
            BlogPost(
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
            BlogPost(
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
            BlogPost(
                4,
                "Tringapps",
                "Management",
                R.drawable.profile_avatar,
                "tringapps is now an AWS partner.",
                "#management #tringers #tringapps #AWS #am…",
                R.drawable.banner
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask,
            "HR Team"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask1,
                "Creative Bees"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask3,
                "TechmMads"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask1,
                "Cloud 9"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask3,
                "Mr Beast"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask,
                "Yes Theory"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask3,
                "Unibeacon"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask3,
                "Xmen"
            )
        )
        userList.add(
            Users(
                R.drawable.image_mask3,
                "BatCave"
            )
        )


        cousreList.add(
            Course(
                R.drawable.course1,
                "AWS Dynamo DB"
            )
        )
        cousreList.add(
            Course(
                R.drawable.course2,
                "Portfolio Management"
            )
        )
        userAdapter.submitList(userList)
        blogAdapter.submitList(list)
    }

    private fun initRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val recyclerViewHor = view.findViewById<RecyclerView>(R.id.usersList)
        val recyclerViewHorCourse = view.findViewById<RecyclerView>(R.id.courseList)

        userAdapter = ActiveUserAdapter()
        blogAdapter = PostAdapter()
        courseAdapter = CourseAdapter()

        recyclerViewHor.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        }
        recyclerView.apply {

            adapter = blogAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        recyclerViewHorCourse.apply {

            adapter = courseAdapter
            layoutManager = LinearLayoutManager(activity,RecyclerView.HORIZONTAL,false)
        }

    }

}