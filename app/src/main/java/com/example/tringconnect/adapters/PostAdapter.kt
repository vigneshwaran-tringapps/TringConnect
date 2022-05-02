package com.example.tringconnect.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tringconnect.R
import com.example.tringconnect.models.BlogPost
import de.hdodenhof.circleimageview.CircleImageView


class PostAdapter: RecyclerView.Adapter<PostAdapter.BlogViewHolder>(){



    private var items: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_layout_one, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        when(holder) {

            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<BlogPost>){
        items = blogList
    }
    class BlogViewHolder
    constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val author_name = itemView.findViewById<TextView>(R.id.authorName)
        val author_desc = itemView.findViewById<TextView>(R.id.authorDesc)
        val author_img = itemView.findViewById<CircleImageView>(R.id.authorImg)
        val post_title = itemView.findViewById<TextView>(R.id.postTitle)
        val post_img = itemView.findViewById<ImageView>(R.id.postImage)
        val post_tags = itemView.findViewById<TextView>(R.id.postTags)
//        val post_like = itemView.findViewById<TextView>(R.id.likeCount)
//        val post_comment = itemView.findViewById<TextView>(R.id.commentCount)

        fun bind(BlogPost: BlogPost){

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

//            Glide.with(itemView.context)
//                .applyDefaultRequestOptions(requestOptions)
//                .load(blogPost.image)
//                .into(blog_image)
//            blog_title.setText(blogPost.title)
//            blog_author.setText(blogPost.username)
            author_name.setText(BlogPost.postauthor)
            author_desc.setText(BlogPost.authordesignation)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(BlogPost.authorImage)
                .into(author_img)
            post_title.setText(BlogPost.postTitle)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(BlogPost.postImage)
                .into(post_img)
            post_tags.setText(BlogPost.postTags)


        }

    }

}