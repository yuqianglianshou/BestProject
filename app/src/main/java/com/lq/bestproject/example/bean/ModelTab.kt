package com.lq.bestproject.example.bean

import com.lq.baselibrary.view.tablayout.listener.TabLayoutModel

data class ModelTab(override var tabTitle: String, override var tabSelectedIcon: Int, override var tabUnselectedIcon: Int) : TabLayoutModel