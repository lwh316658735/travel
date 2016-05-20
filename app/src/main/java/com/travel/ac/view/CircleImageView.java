package com.travel.ac.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import java.io.InputStream;

/**
 * Created by lwh on 2016/5/20. description
 */
public class CircleImageView extends RecyclingImageView {

    private Bitmap mBitmap;
    private Bitmap mCanvasBitmap;
    private static final String TAG      = "CircleImageView";
    private              float  mDensity = 1.5f;
    private DisplayMetrics mDisplayMetrics;

    public CircleImageView(Context context) {
        super(context, null);
        //        InputStream in = getResources().openRawResource(R.mipmap.main_moren);
        //        mBitmap = BitmapFactory.decodeStream(in);
        //        drawIntoBitmap(mBitmap);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //        Log.e(TAG, "CircleImageView: " + getBackground());
        //        InputStream in = getResources().openRawResource(R.mipmap.main_moren);
        //        mBitmap = BitmapFactory.decodeStream(in);
        //        drawIntoBitmap(mBitmap);
        mDisplayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        //        mDensity = displayMetrics.density;
        //        Log.e(TAG, "CircleImageView: " + mDensity);
    }

    public void setImage(int image) {
        InputStream in = getResources().openRawResource(image);
        mBitmap = BitmapFactory.decodeStream(in);
        invalidate();
    }

    public void setImage(Drawable image) {
        //        int intrinsicWidth  = getDrawable().getIntrinsicWidth();
        //        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        int width  = (int) (mDisplayMetrics.widthPixels - 95);
        int height = (int) (500);
        mBitmap = Bitmap.createBitmap((int) (width), (int) (height), image.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(mBitmap);
        image.setBounds(0, 0, width, height);
        image.draw(canvas);
        invalidate();

    }

    public void setImage(Bitmap image) {
        mBitmap = image;
        invalidate();

    }

    private void drawIntoBitmap(Bitmap src) {
        int r = src.getWidth() > src.getHeight() ? src.getHeight() : src.getWidth();
        mCanvasBitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(mCanvasBitmap);
        Paint  p = new Paint();
        p.setAntiAlias(true);
        c.drawCircle(r / 2, r / 2, r / 2, p);
        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        c.drawBitmap(src, 0, 0, p);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Bitmap circleRactBitmap(Bitmap src) {
        if (src != null) {
            mCanvasBitmap = Bitmap.createBitmap(src.getWidth(), src.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(mCanvasBitmap);
            Paint  p      = new Paint(Paint.ANTI_ALIAS_FLAG);
            canvas.drawRoundRect(0, 0, src.getWidth(), src.getHeight(), 20, 20, p);
            p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(src, 0, 0, p);
        }
        return mCanvasBitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = circleRactBitmap(mBitmap);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
        super.onDraw(canvas);
    }

}
