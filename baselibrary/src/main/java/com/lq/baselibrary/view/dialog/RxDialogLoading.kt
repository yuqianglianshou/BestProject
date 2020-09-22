package com.lq.baselibrary.view.dialog

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.lq.baselibrary.R
import com.lq.baselibrary.view.dialog.loadingview.SpinKitView


/**
 * @author Tamsiree
 * @date 2017/3/16
 */
class RxDialogLoading : RxDialog {
    lateinit var loadingView: SpinKitView
        private set
    lateinit var dialogContentView: View
        private set
    lateinit var textView: TextView
        private set

    constructor(context: Context, themeResId: Int) : super(context, themeResId) {
        initView(context)
    }

    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) : super(context, cancelable, cancelListener) {
        initView(context)
    }

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Activity) : super(context) {
        initView(context)
    }

    constructor(context: Context, alpha: Float, gravity: Int) : super(context, alpha, gravity) {
        initView(context)
    }

    private fun initView(context: Context) {
        dialogContentView = LayoutInflater.from(context).inflate(R.layout.base_dialog_loading_spinkit, null)
        loadingView = dialogContentView.findViewById(R.id.spin_kit)
        textView = dialogContentView.findViewById(R.id.name)
        setContentView(dialogContentView)
    }

    fun setLoadingText(charSequence: CharSequence?) {
        textView.text = charSequence
    }

    fun setLoadingColor(color: Int) {
        loadingView.color = color
    }


    fun cancel(str: String?) {
        cancel()
    }

    enum class RxCancelType {
        normal, error, success, info
    }
}