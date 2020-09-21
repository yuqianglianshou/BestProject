package com.lq.bestproject.example.activity

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.lq.baselibrary.BaseActivity
import com.lq.baselibrary.util.PermissionUtils
import com.lq.bestproject.R
import kotlinx.android.synthetic.main.activity_permission.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


/**
 *
 * @author : lq
 * @date   : 2020/
 * @desc : 权限声明
 * 注意：需要 去 AndroidManifest 声明
 *
 */
class PermissionActivity : BaseActivity() {

    override fun initContentView(): Int {
        return R.layout.activity_permission
    }

    override fun initUI() {
        findViewById<ImageView>(R.id.iv_back_base).setOnClickListener(View.OnClickListener { onBackPressed() })
        findViewById<TextView>(R.id.tv_title_base).text = "PermissionActivity"
    }

    override fun initData() {
        //sd
        button.setOnClickListener(View.OnClickListener {
            if (!EasyPermissions.hasPermissions(
                    mActivity,
                    *PermissionUtils.getPermissions(PermissionUtils.STORAGE_CODE)
                )
            ) {
                //权限申请
                EasyPermissions.requestPermissions(
                    mActivity,
                    PermissionUtils.STORAGE_MSG,
                    PermissionUtils.STORAGE_CODE,
                    *PermissionUtils.getPermissions(PermissionUtils.STORAGE_CODE)
                )
            }
        })
        //相机权限
        button2.setOnClickListener(View.OnClickListener {
            if (!EasyPermissions.hasPermissions(
                    mActivity,
                    *PermissionUtils.getPermissions(PermissionUtils.CAMERA_CODE)
                )
            ) {
                //权限申请
                EasyPermissions.requestPermissions(
                    mActivity,
                    PermissionUtils.CAMERA_MSG,
                    PermissionUtils.CAMERA_CODE,
                    *PermissionUtils.getPermissions(PermissionUtils.CAMERA_CODE)
                )
            }
        })

        //定位权限
        button4.setOnClickListener(View.OnClickListener {
            if (!EasyPermissions.hasPermissions(
                    mActivity,
                    *PermissionUtils.getPermissions(PermissionUtils.LOCATION_CODE)
                )
            ) {
                //权限申请
                EasyPermissions.requestPermissions(
                    mActivity,
                    PermissionUtils.LOCATION_MSG,
                    PermissionUtils.LOCATION_CODE,
                    *PermissionUtils.getPermissions(PermissionUtils.LOCATION_CODE)
                )
            }
        })
        //电话权限
        button3.setOnClickListener(View.OnClickListener {
            if (!EasyPermissions.hasPermissions(
                    mActivity,
                    *PermissionUtils.getPermissions(PermissionUtils.PHONE_CODE)
                )
            ) {
                //权限申请
                EasyPermissions.requestPermissions(
                    mActivity,
                    PermissionUtils.PHONE_MSG,
                    PermissionUtils.PHONE_CODE,
                    *PermissionUtils.getPermissions(PermissionUtils.PHONE_CODE)
                )
            }
        })

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults,
            object : EasyPermissions.PermissionCallbacks {
                override fun onRequestPermissionsResult(
                    requestCode: Int,
                    permissions: Array<out String>,
                    grantResults: IntArray
                ) {

                }

                override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
                    if (requestCode == PermissionUtils.STORAGE_CODE) {
                        //showToast("sd卡权限申请成功 ")
                    } else if (requestCode == PermissionUtils.CAMERA_CODE) {
                        //showToast("相机权限申请成功 ")
                    } else if (requestCode == PermissionUtils.PHONE_CODE) {
                        //showToast("电话权限申请成功 ")
                    } else if (requestCode == PermissionUtils.LOCATION_CODE) {
                        //showToast("定位权限申请成功 ")
                    } else {
                        //showToast("权限申请成功 $perms")
                    }
                }

                override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
                    //拒绝提示进入设置界面
                    AppSettingsDialog.Builder(mActivity)
                        .setTitle("提示")
                        .setRationale("此app需要这些权限才能正常使用,请点击确认进入设置页面设置。")
                        .build()
                        .show()
                }

            })

    }

}