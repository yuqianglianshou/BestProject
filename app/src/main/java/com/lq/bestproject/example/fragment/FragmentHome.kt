package com.lq.baselibrary.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lq.bestproject.R

class FragmentHome : FragmentLazy {

    /**
     * 共用标志
     */
    private var demo_type = 0

    /**
     * recycle列数
     */
    private val mColumnCount = 2

    constructor()
    private constructor(demo_type: Int) {
        this.demo_type = demo_type
    }


    override fun inflateView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false)
        return view
    }

    override fun initView() {

//        if(mColumnCount<=1){
//            recyclerView.layoutManager = LinearLayoutManager(mContext)
//        }else{
//            recyclerView.layoutManager = GridLayoutManager(mContext,mColumnCount)
//        }

    }

    override fun initData() {

    }


    companion object {
        fun newInstance(demo_type: Int): FragmentHome {
            return FragmentHome(demo_type)
        }
    }
}