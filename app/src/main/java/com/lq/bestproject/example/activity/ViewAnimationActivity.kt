package com.lq.bestproject.example.activity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_view_animation.*

/**
 *
 *@author : lq
 *@date   : 2020/9/17
 *@desc   : view动画
 *
 */
class ViewAnimationActivity : BaseActivity() {
    override fun initContentView(): Int {
        return R.layout.activity_view_animation
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener(View.OnClickListener { onBackPressed() })
        findViewById<TextView>(R.id.tv_title_base).text = "view动画"
    }

    override fun initData() {
        startShake(btn)
        btn.setOnClickListener(View.OnClickListener { startShake(btn) })
    }

}