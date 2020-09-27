package com.lq.bestproject.example

import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import com.lq.bestproject.example.activity.*
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
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "样例"
    }

    override fun initData() {
        button.setOnClickListener { startAc(ViewAnimationActivity::class.java) }
        button2.setOnClickListener { startAc(JetpackActivity::class.java) }
        button3.setOnClickListener { startAc(RecyclerViewActivity::class.java) }
        button4.setOnClickListener { startAc(PermissionActivity::class.java) }
        button5.setOnClickListener { startAc(AppListActivity::class.java) }
        button6.setOnClickListener { startAc(DemoActivity::class.java) }
        button7.setOnClickListener { startAc(ToastActivity::class.java) }
        button8.setOnClickListener { startAc(DialogActivity::class.java) }
        button9.setOnClickListener { startAc(AutoImageViewActivity::class.java) }
        button10.setOnClickListener { startAc(NestedScrollViewActivity::class.java) }
        button11.setOnClickListener { startAc(LoginActivity::class.java) }

    }

}