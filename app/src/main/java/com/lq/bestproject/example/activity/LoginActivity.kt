package com.lq.bestproject.example.activity

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lq.baselibrary.util.DeviceTool.setPortrait
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 独立 登录界面
 */
class LoginActivity : AppCompatActivity() {

    private var screenHeight = 0 //屏幕高度
    private var keyHeight = 0 //软件盘弹起后所占高度
    private lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mContext = this
        setTransparentStatusBar(this) //状态栏透明化
        //设置statusbar 字体 图标（电量，时间） 颜色为灰色，默认是白色的，可以参考，由于背景也是灰色的，所以说作用是弱化了状态栏的存在。
        StatusBarLightMode(this)

        setPortrait(this)

        initView()
        initData()
    }

    fun initView() {
        screenHeight = this.resources.displayMetrics.heightPixels //获取屏幕高度
        keyHeight = screenHeight / 3 //弹起高度为屏幕高度的1/3
        initEvent()
    }

    fun initData() {

    }

    @SuppressLint("ObjectAnimatorBinding")
    private fun initEvent() {
        et_mobile.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.visibility == View.GONE) {
                    iv_clean_phone.visibility = View.VISIBLE
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.visibility = View.GONE
                }
            }
        })
        et_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (!TextUtils.isEmpty(s) && clean_password.visibility == View.GONE) {
                    clean_password.visibility = View.VISIBLE
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.visibility = View.GONE
                }
                if (s.toString().isEmpty()) {
                    return
                }
                if (!s.toString().matches(Regex("[A-Za-z0-9]+"))) {
                    val temp = s.toString()
                    Toast.makeText(mContext, "请输入数字或字母", Toast.LENGTH_SHORT).show()
                    s.delete(temp.length - 1, temp.length)
                    et_password.setSelection(s.length)
                }
            }
        })
        /**
         * 禁止键盘弹起的时候可以滚动
         */
        scrollView.setOnTouchListener { v, event -> true }
        scrollView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
            if (oldBottom != 0 && bottom != 0 && oldBottom - bottom > keyHeight) {

                val dist = content.bottom - bottom
                if (dist > 0) {
                    val mAnimatorTranslateY =
                        ObjectAnimator.ofFloat(content, "translationY", 0.0f, -dist.toFloat())
                    mAnimatorTranslateY.duration = 300
                    mAnimatorTranslateY.interpolator = LinearInterpolator()
                    mAnimatorTranslateY.start()
                }
                service.visibility = View.INVISIBLE
            } else if (oldBottom != 0 && bottom != 0 && bottom - oldBottom > keyHeight) {
                if (content.bottom - oldBottom > 0) {
                    val mAnimatorTranslateY =
                        ObjectAnimator.ofFloat(content, "translationY", content.translationY, 0f)
                    mAnimatorTranslateY.duration = 300
                    mAnimatorTranslateY.interpolator = LinearInterpolator()
                    mAnimatorTranslateY.start()
                }
                service.visibility = View.VISIBLE
            }
        }
        btn_login.setOnClickListener { hideSoftInput(mContext) }

        iv_clean_phone.setOnClickListener { et_mobile.setText("") }
        clean_password.setOnClickListener { et_password.setText("") }
        iv_show_pwd.setOnClickListener {
            if (et_password.inputType != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                et_password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                iv_show_pwd.setImageResource(R.mipmap.pass_visuable)
            } else {
                et_password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                iv_show_pwd.setImageResource(R.mipmap.pass_gone)
            }
            val pwd = et_password.text.toString()
            if (!TextUtils.isEmpty(pwd)) et_password.setSelection(pwd.length)
        }

    }


    /**
     * 透明状态栏 导航栏
     */
    fun setTransparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) //透明状态栏
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION) //透明导航栏
        }
    }

    /**
     * 设置状态栏黑色字体图标，
     * 适配4.4以上版本MIUIV、Flyme和6.0以上版本其他Android
     *
     * @param activity
     * @return 1:MIUUI 2:Flyme 3:android6.0
     */
    fun StatusBarLightMode(activity: Activity): Int {
        var result = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (MIUISetStatusBarLightMode(activity.window, true)) {
                result = 1
            } else if (FlymeSetStatusBarLightMode(activity.window, true)) {
                result = 2
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                result = 3
            }
        }
        return result
    }


    /**
     * 设置状态栏字体图标为深色，需要MIUIV6以上
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    fun MIUISetStatusBarLightMode(window: Window?, dark: Boolean): Boolean {
        var result = false
        if (window != null) {
            val clazz: Class<*> = window.javaClass
            try {
                var darkModeFlag = 0
                val layoutParams = Class.forName("android.view.MiuiWindowManager\$LayoutParams")
                val field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE")
                darkModeFlag = field.getInt(layoutParams)
                val extraFlagField = clazz.getMethod(
                    "setExtraFlags",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType
                )
                if (dark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag) //状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag) //清除黑色字体
                }
                result = true
            } catch (e: Exception) {
            }
        }
        return result
    }

    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     *
     * @param window 需要设置的窗口
     * @param dark   是否把状态栏字体及图标颜色设置为深色
     * @return boolean 成功执行返回true
     */
    fun FlymeSetStatusBarLightMode(window: Window?, dark: Boolean): Boolean {
        var result = false
        if (window != null) {
            try {
                val lp = window.attributes
                val darkFlag = WindowManager.LayoutParams::class.java
                    .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON")
                val meizuFlags = WindowManager.LayoutParams::class.java
                    .getDeclaredField("meizuFlags")
                darkFlag.isAccessible = true
                meizuFlags.isAccessible = true
                val bit = darkFlag.getInt(null)
                var value = meizuFlags.getInt(lp)
                value = if (dark) {
                    value or bit
                } else {
                    value and bit.inv()
                }
                meizuFlags.setInt(lp, value)
                window.attributes = lp
                result = true
            } catch (e: Exception) {
            }
        }
        return result
    }

    /**
     * 避免输入法面板遮挡
     *
     * 在manifest.xml中activity中设置
     *
     * android:windowSoftInputMode="stateVisible|adjustResize"
     */
    /**
     * 动态隐藏软键盘
     *
     * @param activity activity
     */
    fun hideSoftInput(activity: Activity) {
        val view = activity.window.peekDecorView()
        if (view != null) {
            val inputmanger = activity
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmanger.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}