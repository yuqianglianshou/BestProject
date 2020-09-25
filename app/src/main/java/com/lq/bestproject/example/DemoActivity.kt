package com.lq.bestproject.example

import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import com.lq.bestproject.example.activity.ToastActivity
import kotlinx.android.synthetic.main.activity_demo.*


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   :
 *
 */
class DemoActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_demo
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "Demo"
    }

    override fun initData() {
        btn.setOnClickListener {
            startAc(ToastActivity::class.java)
        }
    }

}