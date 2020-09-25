package com.lq.bestproject.example.activity

import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.view.ToastBest
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_toast.*


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   :
 *
 */
class ToastActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_toast
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "Toast的展示使用"
    }

    override fun initData() {

        button_error_toast.setOnClickListener {
            ToastBest.error(
                mActivity,
                "这是一个提示错误的Toast！"
            )?.show()
        }
        button_success_toast.setOnClickListener {
            ToastBest.success(
                mActivity,
                "这是一个提示成功的Toast!"
            )?.show()
        }
        button_info_toast.setOnClickListener {
            ToastBest.info(
                mActivity,
                "这是一个提示信息的Toast."
            )?.show()
        }
        button_warning_toast.setOnClickListener {
            ToastBest.warning(
                mActivity,
                "这是一个提示警告的Toast."
            )?.show()
        }
        button_normal_toast_wo_icon.setOnClickListener {
            ToastBest.normalNoIcon(
                mActivity,
                "这是一个普通的没有ICON的Toast"
            )?.show()
        }
        button_normal_toast_w_icon.setOnClickListener {
            ToastBest.normal(
                mActivity,
                "这是一个普通的自定义ICON的Toast",
                mActivity.resources.getDrawable(R.mipmap.ic_clover)
            )?.show()
        }
        button_system.setOnClickListener {
            ToastBest.showToast(
                mActivity,
                "这是一个系统的Toast",
                false
            )
        }
    }

}