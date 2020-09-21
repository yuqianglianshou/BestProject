package com.lq.baseproject.example.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lq.bestproject.R
import com.lq.bestproject.example.ExampleActivity
import kotlinx.android.synthetic.main.fragment_placeholder.*

class FragmentPlaceholder : FragmentLazy() {

    override fun inflateView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, savedInstanceState: Bundle?): View {
        return layoutInflater.inflate(R.layout.fragment_placeholder, viewGroup, false)
    }

    override fun initView() {

        btn.setOnClickListener {
            startActivity(Intent(mContext, ExampleActivity::class.java))
        }
    }

    override fun initData() {}

    companion object {
        fun newInstance(): FragmentPlaceholder {
            return FragmentPlaceholder()
        }
    }
}