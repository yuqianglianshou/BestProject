package com.lq.bestproject.example.activity

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.util.DeviceTool
import com.lq.baselibrary.util.SPTool
import com.lq.bestproject.MainActivity
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_splash.*


/**
 * 闪屏
 */
class SplashActivity : BaseActivity() {

    override fun initWindow() {
        setTransparentStatusBar(mActivity)
    }

    override fun initContentView(): Int {
        return R.layout.activity_splash
    }

    override fun initUI() {
        tv_version.text = String.format("VERSION %s", DeviceTool.getAppVersionName(mActivity))
    }

    override fun initData() {
        SPTool.putBoolean(mActivity,"key",false)
        SPTool.putBoolean(mActivity,"key2",false)
    }

    override fun onResume() {
        super.onResume()
        startAnimation(rl_splash)
    }

    fun startAnimation(view: View) {
        var animation = AnimationUtils.loadAnimation(mActivity, R.anim.base_splash_alpha)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startAc(MainActivity::class.java)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        view.startAnimation(animation)
    }
}