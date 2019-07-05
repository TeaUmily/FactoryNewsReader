package com.example.app_single.single.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.app_single.R
import com.example.app_single.view_model.SingleVM
import kotlinx.android.synthetic.main.fragment_pager_item.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SingleArticleFragment : Fragment() {

    private val viewModel by sharedViewModel<SingleVM>()


    companion object {
        const val EXTRA_POSITION = "EXTRA_POSITION"
        fun newInstance(position: Int): SingleArticleFragment {
            val fragment = SingleArticleFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_POSITION, position)
            fragment.arguments = bundle
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pager_item, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = this.arguments!!.getInt(EXTRA_POSITION)

        val article = viewModel.getArticle(position)

        Glide.with(featuredImage.context)
            .load(article.image)
            .into(featuredImage)

        tvTitle.text = article.title
        tvDesription.text = article.description

        featuredImage.setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(childFragmentManager, "BottomSheetFragment")
        }

    }

}