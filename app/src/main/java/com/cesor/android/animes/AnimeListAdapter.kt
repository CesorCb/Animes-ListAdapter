package com.cesor.android.animes

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.cesor.android.animes.databinding.ItemAnimeBinding

/****
 * Project: Animes
 * From: com.cesor.android.animes
 * Created by: César Castro on 16/06/2022 at 16:19.
 ***/
class AnimeListAdapter(private val listener: OnClickListener)
    : ListAdapter<Anime, RecyclerView.ViewHolder>(AnimeDiffCallback()) {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val anime = getItem(position)
        with(holder as ViewHolder){
            setListener(anime)
            binding.tvTitle.text = anime.name
            Glide.with(context)
                .asBitmap()
                .load(anime.imgUrl)
                .into(object : CustomTarget<Bitmap>(1280, 720){
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            imgPhoto.scaleType = ImageView.ScaleType.CENTER_CROP
                            imgPhoto.setImageBitmap(resource)
                        }
                    }

                    override fun onLoadStarted(placeholder: Drawable?) {
                        super.onLoadStarted(placeholder)
                        binding.imgPhoto.setImageResource(R.drawable.ic_access_time)
                    }

                    override fun onLoadFailed(errorDrawable: Drawable?) {
                        super.onLoadFailed(errorDrawable)
                        binding.progressBar.visibility = View.GONE
                        binding.imgPhoto.setImageResource(R.drawable.ic_error_outline)
                    }
                    override fun onLoadCleared(placeholder: Drawable?) {}
                })
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemAnimeBinding.bind(view)

        fun setListener(anime: Anime){
            binding.root.setOnClickListener { listener.onClick(anime) }
        }
    }

    class AnimeDiffCallback : DiffUtil.ItemCallback<Anime>(){
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean = oldItem == newItem
    }
}