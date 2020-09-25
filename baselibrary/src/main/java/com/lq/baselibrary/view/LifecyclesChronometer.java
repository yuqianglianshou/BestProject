package com.lq.baselibrary.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author : lq
 * @date : 2020/3/24
 * @desc : 计时控件
 */
public class LifecyclesChronometer extends Chronometer implements LifecycleObserver {
    /**
     * 记录一次计时器从开始到停止的时间间隔
     */
    private long elapsedTime = 0;

    public LifecyclesChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //SystemClock.elapsedRealtime() 获取从设备boot后经历的时间值。与系统时间无关，防止修改系统时间引起计时错误。
    //    setBase(SystemClock.elapsedRealtime());

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resumeMeter() {
        //开始计时时累积上一次计时的时间，比如计时器到3秒应用退到后台，5秒后再次打开应用，如果不做操作，此时计时器显示是8秒然后继续计时，
        //此处的效果是计时器显示3秒然后继续计时，丢弃了应用不属于前台进程时的时间。
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pauseMeter() {
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }
}
