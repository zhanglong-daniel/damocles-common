/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.damocles.common.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;

/**
 * Created by zhanglong02 on 2017/10/13.
 */

public class BitmapUtils {

    public static Bitmap createCircleImage(Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        int width = source.getWidth();
        int height = source.getHeight();
        float cx = width / 2.0f;
        float cy = height / 2.0f;
        float radius = Math.min(width, height) / 2.0f;
        Bitmap target = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        // 产生一个同样大小的画布
        Canvas canvas = new Canvas(target);
        // 首先绘制圆形
        canvas.drawCircle(cx, cy, radius, paint);
        // 使用SRC_IN
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        // 绘制图片
        canvas.drawBitmap(source, 0, 0, paint);
        return target;
    }

    public static Bitmap viewToBitmap(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }
}
