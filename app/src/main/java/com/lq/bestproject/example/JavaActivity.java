package com.lq.bestproject.example;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * @author : lq
 * @date : 2020/9/28
 * @desc :
 */
class JavaActivity extends AppCompatActivity {
    private static final String TAG = "JavaActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate:  ");

//        new AnalysisEventListener<AppInfoBean>(){
//            @Override
//            public void invoke(AppInfoBean data, AnalysisContext context) {
//
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//
//            }
//        };
    }
}
