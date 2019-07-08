package com.example.app_home.news.view_holder

import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.app_home.R
import com.example.app_home.R2
import com.example.deliverytest.base.epoxy.KotlinHolder

@EpoxyModelClass(layout = R2.layout.cell_deleted_news_item)
abstract class DeletedNewsItemHolderModel : EpoxyModelWithHolder<DeletedNewsItemHolder>() {

    @EpoxyAttribute
    lateinit var image: String
    @EpoxyAttribute
    lateinit var description: String

    override fun bind(holder: DeletedNewsItemHolder) {

        Glide.with(holder.imageView.context)
            .load(image)
            .into(holder.imageView)
        holder.description.text = description
    }

}

class DeletedNewsItemHolder : KotlinHolder() {

    val imageView by bind<ImageView>(R.id.ivNewsDeleted)
    val description by bind<TextView>(R.id.tvDescriptionDeleted)
}