package com.lq.bestproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.view.tablayout.listener.OnTabSelectListener
import com.lq.baselibrary.view.tablayout.listener.TabLayoutModel
import com.lq.baseproject.example.adapter.AdapterFVP
import com.lq.baseproject.example.fragment.FragmentHomeType
import com.lq.baseproject.example.fragment.FragmentPlaceholder
import com.lq.bestproject.example.bean.ModelFVP
import com.lq.bestproject.example.bean.ModelTab
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_main
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tv_title_base).text = "主流UI"

    }

    override fun initData() {
        initTablayout()
    }

    private fun initTablayout() {

        val mTabEntities: ArrayList<TabLayoutModel> = ArrayList<TabLayoutModel>()
        val modelFVPList: ArrayList<ModelFVP> = ArrayList<ModelFVP>()
        val mIconSelectIds = intArrayOf(
            R.mipmap.ic_data,
            R.mipmap.ic_main,
            R.mipmap.ic_mine
        )
        val mIconUnselectIds = intArrayOf(
            R.mipmap.ic_data_,
            R.mipmap.ic_main_,
            R.mipmap.ic_mine_
        )
        if (modelFVPList.isEmpty()) {
            modelFVPList.add(ModelFVP("data", FragmentPlaceholder.newInstance()))
            modelFVPList.add(ModelFVP("main", FragmentHomeType.newInstance()))
            modelFVPList.add(ModelFVP("mine", FragmentPlaceholder.newInstance()))
        }
        for (i in modelFVPList.indices) {
            mTabEntities.add(
                ModelTab(
                    modelFVPList[i].name,
                    mIconSelectIds[i],
                    mIconUnselectIds[i]
                )
            )
        }
        view_pager.setAdapter(AdapterFVP(supportFragmentManager, modelFVPList))
        tab_layout1.setTabData(mTabEntities)

        tab_layout1.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                view_pager.setCurrentItem(position)
            }

            override fun onTabReselect(position: Int) {}
        })
        view_pager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tab_layout1.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        view_pager.setCurrentItem(0)
    }
}