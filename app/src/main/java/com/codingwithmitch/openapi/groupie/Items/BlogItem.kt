package com.codingwithmitch.openapi.groupie.Items

import coil.ImageLoader
import coil.api.load
import com.codingwithmitch.openapi.R
import com.codingwithmitch.openapi.models.BlogPost
import com.codingwithmitch.openapi.util.DateUtils
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.layout_blog_list_item.*

open class BlogItem(
    private val blogPost: BlogPost,
    private val imageLoader: ImageLoader
): Item() {

    override fun getLayout(): Int {
        return R.layout.layout_blog_list_item
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {

        viewHolder.blog_image
            .load(blogPost.image, imageLoader)

        viewHolder.blog_title.setText(blogPost.title)
        viewHolder.blog_author.setText(blogPost.username)
        viewHolder.blog_update_date.setText(DateUtils.convertLongToStringDate(blogPost.date_updated))
    }
}