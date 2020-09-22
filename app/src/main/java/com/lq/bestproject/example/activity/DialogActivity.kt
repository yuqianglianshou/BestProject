package com.lq.bestproject.example.activity

import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.view.dialog.*
import com.lq.bestproject.R
import com.lq.bestproject.example.util.showToast
import kotlinx.android.synthetic.main.activity_dialog.*

/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   :
 *
 */
class DialogActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_dialog
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "dialog"
    }

    override fun initData() {
        button_DialogShapeLoading.setOnClickListener {
            val rxDialogShapeLoading = RxDialogShapeLoading(mActivity)
            rxDialogShapeLoading.show()
        }

        button_DialogLoadingspinkit.setOnClickListener {
            val rxDialogLoading = RxDialogLoading(mActivity)
            rxDialogLoading.show()
        }

        button_DialogSureCancle.setOnClickListener {
            val rxDialogSureCancel = RxDialogSureCancel(mActivity)
            rxDialogSureCancel.setTitle("标题") //注释可去掉
            rxDialogSureCancel.setContent("君不见长江之水天上来？")
            rxDialogSureCancel.setSureListener { rxDialogSureCancel.cancel() }
            rxDialogSureCancel.setCancelListener { rxDialogSureCancel.cancel() }
            rxDialogSureCancel.show()
        }

        button_DialogSure.setOnClickListener {
            val rxDialogSure = RxDialogSure(mActivity)
            rxDialogSure.setTitle("cc")
            rxDialogSure.setContent("是曙光 是梦想 是这人间值得")
            rxDialogSure.setSureListener { rxDialogSure.cancel() }
            rxDialogSure.show()
        }

        button_DialogEditTextSureCancle.setOnClickListener {
            val rxDialogEditSureCancel = RxDialogEditSureCancel(mActivity)
            rxDialogEditSureCancel.setTitle("cc")
            rxDialogEditSureCancel.sureView.setOnClickListener {
                mActivity.showToast(
                    rxDialogEditSureCancel.editText.getText().toString()
                )
            }
            rxDialogEditSureCancel.cancelView
                .setOnClickListener { rxDialogEditSureCancel.cancel() }
            rxDialogEditSureCancel.show()
        }
        button_DialogWheelYearMonthDay.setOnClickListener {
            // ------------------------------------------------------------------选择日期开始
            val mRxDialogDate = RxDialogDate(mActivity, 1994)
            mRxDialogDate.sureView.setOnClickListener {
                val builder = StringBuilder("")
                if (mRxDialogDate.checkBoxDay.isChecked()) {
                    builder.append(mRxDialogDate.selectorYear.toString() + "年")
                        .append(mRxDialogDate.selectorMonth + "月")
                        .append(mRxDialogDate.selectorDay + "日")
                } else {
                    builder.append(mRxDialogDate.selectorYear.toString() + "年")
                        .append(mRxDialogDate.selectorMonth + "月")
                }
                button_DialogWheelYearMonthDay.setText(builder.toString())
                mRxDialogDate.cancel()
            }
            mRxDialogDate.cancleView
                .setOnClickListener { mRxDialogDate.cancel() }
            mRxDialogDate.show()
            // ------------------------------------------------------------------选择日期结束
        }
    }

}