package com.example.app_home.news.view_holder


import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.app_home.R
import com.example.app_home.R2
import com.example.deliverytest.base.epoxy.KotlinHolder

@EpoxyModelClass(layout = R2.layout.cell_news_item)
abstract class NewsItemHolderModel : EpoxyModelWithHolder<NewsItemHolder>() {

    @EpoxyAttribute
    lateinit var image: String
    @EpoxyAttribute
    lateinit var description: String
    @EpoxyAttribute(hash = false)
    lateinit var clickListener: View.OnClickListener
    @EpoxyAttribute
    var newsTab: Boolean = false
    private var isImageClicked = false

    override fun bind(holder: NewsItemHolder) {

        if(newsTab){
            holder.description.setOnClickListener(clickListener)

            holder.imageView.setOnClickListener {
                isImageClicked = !isImageClicked
                changeContent(holder)
            }

            holder.deleteBtn.setOnClickListener {
                isImageClicked = !isImageClicked
                clickListener.onClick(it)
                changeContent(holder)
            }
        }

        Glide.with(holder.imageView.context)
            .load(image)
            .into(holder.imageView)
        holder.description.text = description
    }

    private fun changeContent(holder: NewsItemHolder) {
        if (isImageClicked) {
            holder.description.visibility = View.INVISIBLE
            holder.deleteBtn.visibility = View.VISIBLE
        } else {
            holder.description.visibility = View.VISIBLE
            holder.deleteBtn.visibility = View.INVISIBLE
        }
    }

}

class NewsItemHolder : KotlinHolder() {

    val imageView by bind<ImageView>(R.id.ivNews)
    val description by bind<TextView>(R.id.tvDescription)
    val deleteBtn by bind<Button>(R.id.deleteBtn)

}

