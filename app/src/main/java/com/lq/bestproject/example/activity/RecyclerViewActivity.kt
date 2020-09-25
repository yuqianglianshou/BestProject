package com.lq.bestproject.example.activity

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

/**
 *
 *@author : lq
 *@date   : 2020/9/22
 *@desc   :
 *
 */
class RecyclerViewActivity : BaseActivity() {
    override fun initContentView(): Int {
        return R.layout.activity_recyclerview
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "recyclerview"

        rv_activity.layoutManager = LinearLayoutManager(mActivity)
//        rv_activity.adapter = BaseQuickAdapter

    }

    override fun initData() {

    }
}