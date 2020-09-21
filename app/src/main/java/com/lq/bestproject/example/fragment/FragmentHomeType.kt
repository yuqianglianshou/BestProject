package com.lq.baseproject.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lq.baseproject.example.adapter.AdapterFVP
import com.lq.bestproject.R
import com.lq.bestproject.example.bean.ModelFVP
import kotlinx.android.synthetic.main.fragment_home_type.*

import java.util.*

class FragmentHomeType : FragmentLazy() {

    private val modelFVPList: MutableList<ModelFVP> = ArrayList()


    override fun inflateView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = layoutInflater.inflate(R.layout.fragment_home_type, viewGroup, false)
        return view
    }

    override fun initView() {

    }

    override fun initData() {

        if (modelFVPList.isEmpty()) {
            modelFVPList.add(ModelFVP("诗", FragmentHome.newInstance(0)))
            modelFVPList.add(ModelFVP("远方", FragmentHome.newInstance(1)))
            modelFVPList.add(ModelFVP("我", FragmentHome.newInstance(2)))
        }

        view_pager.adapter = AdapterFVP(childFragmentManager, modelFVPList)
        tab_layout.setViewPager(view_pager)
    }

    companion object {
        fun newInstance(): FragmentHomeType {
            return FragmentHomeType()
        }
    }
}