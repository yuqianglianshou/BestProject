package com.lq.bestproject.example.activity

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.util.FileTool
import com.lq.bestproject.R
import com.lq.bestproject.example.activity.ToastActivity
import kotlinx.android.synthetic.main.activity_demo.*
import java.io.File


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   : 设置
 *
 */
class SettingsActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_settings
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "Settings"
    }

    override fun initData() {


    }

}