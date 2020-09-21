package com.lq.bestproject.example.activity

import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R

/**
 * @author tamsiree
 */
class AutoImageViewActivity : BaseActivity() {


    override fun initWindow() {
        setTransparentStatusBar(mActivity)
    }

    override fun initContentView(): Int {

        return R.layout.activity_auto_image_view
    }

    override fun initUI() {

    }

    override fun initData() {

    }


}