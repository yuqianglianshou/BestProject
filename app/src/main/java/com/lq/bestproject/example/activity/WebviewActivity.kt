package com.lq.bestproject.example.activity

import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.view.dialog.RxDialogShapeLoading
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_webview.*


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   : webview 加载在线文档
 *
 */
class WebviewActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_webview
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "Webview"

        findViewById<TextView>(R.id.tv_right_base).text = "设置"
        findViewById<TextView>(R.id.tv_right_base).setOnClickListener {
            startAc(SettingsActivity::class.java)
        }


    }

    override fun initData() {
        val rxDialogShapeLoading = RxDialogShapeLoading(mActivity)
        rxDialogShapeLoading.show()

        var webSettings = webview.settings
        //是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webSettings.javaScriptEnabled = true
        //设置js可以直接打开窗口，如window.open()，默认为false
        webSettings.javaScriptCanOpenWindowsAutomatically = true

        webview.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.i(TAG, "onPageFinished: ")
                rxDialogShapeLoading.cancel()
            }
        }

        webview.loadUrl("https://www.yuque.com/liuqingyang-lq82v/xyszlk/fkrw26")
//        webview.loadUrl("https://www.baidu.com")


    }

}