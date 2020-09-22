package com.lq.baselibrary

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity

/**
 *
 *@author : lq
 *@date   : 2020/9/17
 *@desc   :
 *
 */
abstract class BaseActivity : AppCompatActivity() {
    val TAG = javaClass.simpleName

    lateinit var mActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
        initWindow()
        setContentView(initContentView())

        initUI()
        initData()
    }

    open fun initWindow(){}
    abstract fun initContentView(): Int
    abstract fun initUI()
    abstract fun initData()

    /**
     * Activity 跳转
     */
    open fun startAc(cls: Class<*>?) {
        startActivity(Intent(mActivity, cls))
    }

    /**
     * view 晃动效果(3次)
     *
     * @param view
     */
    open fun startShake(view: View) {
        view.startAnimation(AnimationUtils.loadAnimation(mActivity, R.anim.base_shake))
    }

    /**
     * 设置透明状态栏(api大于19方可使用)
     *
     * 可在Activity的onCreat()中调用
     *
     * 需在顶部控件布局中加入以下属性让内容出现在状态栏之下
     *
     * android:clipToPadding="true"
     *
     * android:fitsSystemWindows="true"
     *
     * @param activity activity
     */
    open fun setTransparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) //透明状态栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION) //透明导航栏
        }
    }
}