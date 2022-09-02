package com.flowassignment.navermoviesearchapp.wiget

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.flowassignment.navermoviesearchapp.R

@BindingAdapter("setImage")
fun setImage(imageview: ImageView, url: String?) {
    url?.let {
        Glide.with(imageview.context)
            .load(url)
            .error(R.mipmap.ic_launcher)
            .into(imageview)
    }
}