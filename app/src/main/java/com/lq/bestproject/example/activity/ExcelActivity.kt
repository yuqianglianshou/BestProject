package com.lq.bestproject.example.activity

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.util.FileTool
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_excel.*
import java.io.File
import java.io.IOException


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   :
 *
 */
class ExcelActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_excel
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "excel"
    }

    override fun initData() {
        btn.setOnClickListener {
            Thread{
                Log.i(TAG, "initData:1 ")
//                ReadFileJsonUtils.readAndWrite(mActivity)

                FileTool.createOrExistsDir(FileTool.sDCardPath + "abc")

                val fileName = FileTool.sDCardPath + "abc/" + "excel.xlsx"
                FileTool.initFile(fileName)


                try {
                    val `is` = mActivity.resources.assets.open("excel.xlsx")

                    FileTool.copyFile(`is`, File(fileName))


                } catch (e: IOException) {
                    e.printStackTrace()
                }

                Log.i(TAG, "initData:2 ")
            }.start()
//            startAc(ToastActivity::class.java)
        }

    }

}