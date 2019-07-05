package com.example.app_home.news.view_holder

import android.view.View
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


    override fun bind(holder: NewsItemHolder) {

        holder.cell.setOnClickListener(clickListener)
        Glide.with(holder.imageView.context)
            .load(image)
            .into(holder.imageView)
        holder.description.text = description
    }
}

class NewsItemHolder : KotlinHolder() {

    val imageView by bind<ImageView>(R.id.ivNews)
    val description by bind<TextView>(R.id.tvDescription)
    val cell by bind<View>(R.id.articleCell)

}