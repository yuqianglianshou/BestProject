package com.lq.bestproject.example.activity

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.view.dialog.RxDialogShapeLoading
import com.lq.bestproject.R
import com.lq.bestproject.example.animater.CustomAnimation2
import com.lq.bestproject.example.bean.AppInfoBean
import com.lq.bestproject.example.view.divider.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_app_list.*
import java.util.*
import kotlin.collections.ArrayList


/**
 *
 *@author : lq
 *@date   : 2020/
 *@desc   :安装应用列表
 *
 */
class AppListActivity : BaseActivity() {

    private val listData: MutableList<AppInfoBean> = ArrayList()

    private lateinit var adapter: BaseQuickAdapter<AppInfoBean, BaseViewHolder>

    override fun initContentView(): Int {
        return R.layout.activity_app_list
    }


    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "安装应用列表"

        rv_applist.setHasFixedSize(true)
        rv_applist.layoutManager = LinearLayoutManager(mActivity)
        //分割线
        rv_applist.addItemDecoration(
            DividerItemDecoration(
                mActivity,
                DividerItemDecoration.VERTICAL
            )
        )

        adapter =
            object : BaseQuickAdapter<AppInfoBean, BaseViewHolder>(
                R.layout.list_item_applist,
                listData
            ) {
                override fun convert(holder: BaseViewHolder, item: AppInfoBean) {

                    holder.getView<ImageView>(R.id.iv_icon).setImageDrawable(item.icon)
                    holder.getView<TextView>(R.id.tv_name).setText(item.appName)
                }

            }

        adapter.animationEnable = true

        //默认效果 渐显
//        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn)
        //左侧进入动画
//        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.SlideInLeft)
        //由远及近的效果
//        adapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.ScaleIn)

        //自定义效果， 侧入 晃动 效果
        adapter.adapterAnimation = CustomAnimation2()


        //动画是否只执行一次
        adapter.isAnimationFirstOnly = false

        adapter.setOnItemClickListener { adapter, view, position ->
            Log.i(TAG, "initUI: " + adapter.getItem(position).toString())
        }

        rv_applist.adapter = adapter

        adapter.setEmptyView(R.layout.load_data_empty)


    }

    lateinit var rxDialogShapeLoading: RxDialogShapeLoading
    override fun initData() {
        rxDialogShapeLoading = RxDialogShapeLoading(mActivity)
        rxDialogShapeLoading.show()


        Thread {
            loadAppInfo()
        }.start()


    }

    fun loadAppInfo() {
        var mpm: PackageManager = mActivity.packageManager
        val list: MutableList<ApplicationInfo> =
            mpm.getInstalledApplications(0)

        // 排序
        Collections.sort(list, ApplicationInfo.DisplayNameComparator(mpm))

        for (item in list) {
            // 非系统应用
            if ((item.flags and ApplicationInfo.FLAG_SYSTEM) <= 0) {
                listData.add(
                    AppInfoBean(
                        item.loadLabel(mpm).toString(), item.packageName, item.loadIcon(
                            mpm
                        )
                    )
                )
            }
        }
        runOnUiThread {
            rxDialogShapeLoading.cancel()

            adapter?.notifyDataSetChanged()
            textView2.setText("共有 " + listData?.size + " 个非系统应用");
        }
    }
}