package com.lq.baselibrary.util;

import android.Manifest;

/**
 * @author : lq
 * @date :
 * @desc : 危险权限 常量
 */
public class PermissionUtils {
    /*    <!--需要手动允许权限——————————————————————————————-->
    <!--电话权限-->
    <uses-permission android:name="android.permission.READ_CALL_LOG" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_CALL_LOG" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.CALL_PHONE" />
    <uses-permission android:name="android.permission.WRITE_CALL_LOG" />
    <uses-permission android:name="android.permission.USE_SIP" />
    <uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS" />
    <uses-permission android:name="com.android.voicemail.permission.ADD_VOICEMAIL" />
    <!--通讯录权限-->
    <uses-permission android:name="android.permission.WRITE_CONTACTS" />
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <!--日历权限-->
    <uses-permission android:name="android.permission.READ_CALENDAR" />
    <uses-permission android:name="android.permission.WRITE_CALENDAR" />
    <!--摄像头权限-->
    <uses-permission android:name="android.permission.CAMERA" />
    <!--传感器权限-->
    <uses-permission android:name="android.permission.BODY_SENSORS" />
    <!--定位权限-->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <!--存储权限-->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!--录制音频权限-->
    <uses-permission android:name="android.permission.RECORD_AUDIO" />
    <!--短信权限-->
    <uses-permission android:name="android.permission.READ_SMS" />
    <uses-permission android:name="android.permission.RECEIVE_WAP_PUSH" />
    <uses-permission android:name="android.permission.RECEIVE_MMS" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.READ_CELL_BROADCASTS" />
    */

    //    摄像头权限
    public static final int CAMERA_CODE = 30000;
    public static final String CAMERA_MSG = "此app需要获取拍照权限";
    //    传感器权限
    public static final int SENSORS_CODE = 30001;
    //   录制音频权限
    public static final int MICROPHONE_CODE = 30002;
    //    日历权限
    public static final int CALENDAR_CODE = 30003;
    //    定位权限
    public static final int LOCATION_CODE = 30004;
    public static final String LOCATION_MSG = "此app需要获取定位权限";
    //    存储权限
    public static final int STORAGE_CODE = 30005;
    public static final String STORAGE_MSG = "此app需要获取SD卡读取权限";
    //    通讯录权限
    public static final int CONTACTS_CODE = 30006;
    //    短信权限
    public static final int SMS_CODE = 30007;
    //    电话权限
    public static final int PHONE_CODE = 30008;
    public static final String PHONE_MSG = "此app需要获取电话权限";


    //    摄像头权限
    public static final String CAMERA = Manifest.permission.CAMERA;
    //    传感器权限
    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;
    //   录制音频权限
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    //    日历权限
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;
    //    定位权限
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    //    存储权限
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    //    通讯录权限
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    //    短信权限
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    //    电话权限
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;

    //    权限组
    public static final class Group {

        public static final String[] CAMERA = new String[]{PermissionUtils.CAMERA};

        public static final String[] SENSORS = new String[]{PermissionUtils.BODY_SENSORS};

        public static final String[] MICROPHONE = new String[]{PermissionUtils.RECORD_AUDIO};

        public static final String[] CALENDAR = new String[]{
                PermissionUtils.READ_CALENDAR,
                PermissionUtils.WRITE_CALENDAR};

        public static final String[] LOCATION = new String[]{
                PermissionUtils.ACCESS_FINE_LOCATION,
                PermissionUtils.ACCESS_COARSE_LOCATION};

        public static final String[] STORAGE = new String[]{
                PermissionUtils.READ_EXTERNAL_STORAGE,
                PermissionUtils.WRITE_EXTERNAL_STORAGE};

        public static final String[] CONTACTS = new String[]{
                PermissionUtils.READ_CONTACTS,
                PermissionUtils.WRITE_CONTACTS,
                PermissionUtils.GET_ACCOUNTS};

        public static final String[] SMS = new String[]{
                PermissionUtils.SEND_SMS,
                PermissionUtils.RECEIVE_SMS,
                PermissionUtils.READ_SMS,
                PermissionUtils.RECEIVE_WAP_PUSH,
                PermissionUtils.RECEIVE_MMS};

        public static final String[] PHONE = new String[]{
                PermissionUtils.READ_PHONE_STATE,
                PermissionUtils.CALL_PHONE,
                PermissionUtils.READ_CALL_LOG,
                PermissionUtils.WRITE_CALL_LOG,
                PermissionUtils.ADD_VOICEMAIL,
                PermissionUtils.USE_SIP,
                PermissionUtils.PROCESS_OUTGOING_CALLS};
    }

    //    根据权限code返回相应的权限组
    public static String[] getPermissions(int requestCode) {
        switch (requestCode) {
            case PermissionUtils.CAMERA_CODE:
                return PermissionUtils.Group.CAMERA;
            case PermissionUtils.SENSORS_CODE:
                return PermissionUtils.Group.SENSORS;
            case PermissionUtils.MICROPHONE_CODE:
                return PermissionUtils.Group.MICROPHONE;
            case PermissionUtils.CALENDAR_CODE:
                return PermissionUtils.Group.CALENDAR;
            case PermissionUtils.LOCATION_CODE:
                return PermissionUtils.Group.LOCATION;
            case PermissionUtils.STORAGE_CODE:
                return PermissionUtils.Group.STORAGE;
            case PermissionUtils.CONTACTS_CODE:
                return PermissionUtils.Group.CONTACTS;
            case PermissionUtils.SMS_CODE:
                return PermissionUtils.Group.SMS;
            case PermissionUtils.PHONE_CODE:
                return PermissionUtils.Group.PHONE;
            default:
                return null;
        }
    }


}
