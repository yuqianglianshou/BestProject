package com.lq.bestproject.example

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import com.lq.bestproject.example.activity.AppListActivity
import com.lq.bestproject.example.activity.AutoImageViewActivity
import com.lq.bestproject.example.activity.PermissionActivity
import com.lq.bestproject.example.activity.ViewAnimationActivity
import kotlinx.android.synthetic.main.activity_example.*


/**
 *
 *@author : lq
 *@date   : 2020/
 *@desc   : 样例
 *
 */
class ExampleActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_example
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener(View.OnClickListener { onBackPressed() })
        findViewById<TextView>(R.id.tv_title_base).text = "样例"
    }

    override fun initData() {
        button.setOnClickListener(View.OnClickListener { startAc(ViewAnimationActivity::class.java) })
        button4.setOnClickListener(View.OnClickListener { startAc(PermissionActivity::class.java) })
        button5.setOnClickListener(View.OnClickListener { startAc(AppListActivity::class.java) })
        button6.setOnClickListener(View.OnClickListener { startAc(DemoActivity::class.java) })
        button9.setOnClickListener(View.OnClickListener { startAc(AutoImageViewActivity::class.java) })

    }

}