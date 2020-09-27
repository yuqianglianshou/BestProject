package com.lq.bestproject.example.activity

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lq.baselibrary.BaseActivity
import com.lq.bestproject.R
import com.lq.bestproject.example.bean.AppInfoBean
import kotlinx.android.synthetic.main.activity_nested_scroll_view.*


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   : 滑动嵌套
 *
 */
class NestedScrollViewActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_nested_scroll_view
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener { onBackPressed() }
        findViewById<TextView>(R.id.tv_title_base).text = "滑动嵌套"
    }

    override fun initData() {
        var listData: MutableList<Int> = ArrayList()
        listData.addAll(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
        rv_nested.layoutManager = LinearLayoutManager(mActivity)

        var adapter =
            object : BaseQuickAdapter<Int, BaseViewHolder>(
                R.layout.list_item_applist,
                listData
            ) {
                override fun convert(holder: BaseViewHolder, item: Int) {

                    holder.getView<TextView>(R.id.tv_name).setText(item.toString())
                }

            }
        rv_nested.adapter = adapter

    }

}