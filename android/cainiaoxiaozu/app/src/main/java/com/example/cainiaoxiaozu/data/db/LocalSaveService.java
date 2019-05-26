package com.example.cainiaoxiaozu.data.db;

import android.content.Context;
import android.graphics.Bitmap;

public interface LocalSaveService {

    /**
     *
     * @param context
     * @param name 确定sharedPreferences，getSharedPreferences中使用
     * @param key xml中找到属性，sharedPreferences.getString中使用
     * @param bitmap 图片转换
     * @return
     */
    boolean saveBitmapToSharedPreferences(Context context, String name, String key, Bitmap bitmap);

    /**
     *
     * @param context
     * @param name 确定sharedPreferences，getSharedPreferences中使用
     * @param key xml中找到属性，sharedPreferences.getString中使用
     * @return
     */
    Bitmap getBitmapFromSharedPreferences(Context context, String name, String key);

    /**
     *
     * @param context
     * @param name 确定sharedPreferences，getSharedPreferences中使用
     * @param key xml中找到属性，sharedPreferences.getString中使用
     * @param content 文本内容
     * @return
     */

    boolean saveTextToSharedPreferences(Context context, String name, String key, String content);

    /**
     *
     * @param context
     * @param name 确定sharedPreferences，getSharedPreferences中使用
     * @param key xml中找到属性，sharedPreferences.getString中使用
     * @return
     */
    String getTextFromSharedPreferences(Context context, String name, String key);


}
