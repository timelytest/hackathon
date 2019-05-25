package com.example.cainiaoxiaozu.data.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class LocalSaveImpl implements LocalSaveService {
    @Override
    public boolean saveBitmapToSharedPreferences(Context context, String name, String key, Bitmap bitmap) {
        //Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.test1);
        //第一步:将Bitmap压缩至字节数组输出流ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        //第二步:利用Base64将字节数组输出流中的数据转换成字符串String
        byte[] byteArray=byteArrayOutputStream.toByteArray();
        String imageString=new String(Base64.encodeToString(byteArray, Base64.DEFAULT));
        //第三步:将String保持至SharedPreferences
        SharedPreferences sharedPreferences=context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key, imageString);
        return true;
    }

    @Override
    public Bitmap getBitmapFromSharedPreferences(Context context, String name, String key) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(name, Context.MODE_PRIVATE);
        //第一步:取出字符串形式的Bitmap
        String imageString=sharedPreferences.getString(key, "");
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        byte[] byteArray=Base64.decode(imageString, Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArray);
        //第三步:利用ByteArrayInputStream生成Bitmap
        Bitmap bitmap= BitmapFactory.decodeStream(byteArrayInputStream);
        return bitmap;
    }

    @Override
    public boolean saveTextToSharedPreferences(Context context, String name, String key, String content) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key, content);
        editor.commit();
        return true;
    }

    @Override
    public String getTextFromSharedPreferences(Context context, String name, String key) {
        SharedPreferences sharedPreferences=context.getSharedPreferences(name, Context.MODE_PRIVATE);
        //第一步:取出字符串
        String textString=sharedPreferences.getString(key, "");

        return textString;
    }
}
