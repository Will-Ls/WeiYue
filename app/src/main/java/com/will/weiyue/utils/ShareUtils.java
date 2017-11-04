package com.will.weiyue.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

/**
 * desc: .
 * author: Will .
 * date: 2017/10/18 .
 */
public class ShareUtils {

    /**
     * 文字分享
     *
     * @param context
     * @param content
     */
    public static void shareText(Context context,String content) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
       // shareIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        shareIntent.setType("text/plain");
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }


    //分享单张图片
    public static void shareSingleImage(Context context, String imageUrl) {
        //由文件得到uri
        Uri imageUri = Uri.parse(imageUrl);
        Log.d("share", "uri:" + imageUri);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }
}
