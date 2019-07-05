package com.example.app_single.single.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app_single.R
import com.example.app_single.utils.convertToNormalDate
import com.example.app_single.view_model.SingleVM
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BottomSheetFragment : BottomSheetDialogFragment() {

    private val viewModel by sharedViewModel<SingleVM>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moreInfoItem = viewModel.getMoreInfo()
        val dateString = convertToNormalDate(moreInfoItem.publishedAt.dropLast(10))

        tvPublishedAt.text = getString(R.string.publishedAt, dateString)
        tvAuthor.text = moreInfoItem.author

    }

}