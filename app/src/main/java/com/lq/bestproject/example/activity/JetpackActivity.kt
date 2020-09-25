package com.lq.bestproject.example.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lq.bestproject.R
import com.lq.bestproject.databinding.ActivityJetpackBinding
import com.lq.bestproject.example.viewmodel.JetpackViewModel


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc   :
 * 布局文件转为 DataBinding layout 形式。option+enter
 */
class JetpackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_jetpack)

        var binding = DataBindingUtil.setContentView<ActivityJetpackBinding>(
            this,
            R.layout.activity_jetpack
        )
        //获取 viewModel 对象
        val viewModel: JetpackViewModel = ViewModelProvider(this).get<JetpackViewModel>(
            JetpackViewModel::class.java
        )

        binding.data = viewModel

        binding.lifecycleOwner = this

        //计时器

        //计时器
        lifecycle.addObserver(binding.textView5)
    }

}