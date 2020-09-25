package com.lq.bestproject.example.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author : lq
 * @date : 2020/3/21
 * @desc :ViewModel
 */
public class JetpackViewModel extends ViewModel {
    /**
     * 计数
     */
    private MutableLiveData<Integer> number = new MutableLiveData<>(0);

    public MutableLiveData<Integer> getNumber() {
        if (number == null) {
            //初始化
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }
        return number;
    }

    public void addNumber(Integer x) {
        number.setValue(number.getValue() + x);
    }

}
//      LiveData与MutableLiveData区别
//        LiveData与MutableLiveData的其实在概念上是一模一样的.唯一几个的区别如下:
//
//        1.MutableLiveData的父类是LiveData
//
//        2.LiveData在实体类里可以通知指定某个字段的数据更新.
//
//        3.MutableLiveData则是完全是整个实体类或者数据类型变化后才通知.不会细节到某个字段