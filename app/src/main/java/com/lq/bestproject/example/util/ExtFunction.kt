package com.lq.bestproject.example.util

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 *
 *@author : lq
 *@date   : 2020/9/21
 *@desc   : 扩展函数
 *
 */

/**
 * Gson
 */
inline fun <reified T> Gson.toModel(json: String): T = fromJson<T>(json, T::class.java)

/**
 *
 * Gson
 * 避免Object对象泛型擦除影响 lq
 *
 * T = List<Object>
 */
inline fun <reified T> Gson.toSuperModel(json: String): T =
    fromJson<T>(json, object : TypeToken<T>() {}.type)

/**
 * Toast
 */
inline fun Context.showToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()