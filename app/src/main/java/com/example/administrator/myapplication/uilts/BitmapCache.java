package com.example.administrator.myapplication.uilts;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.example.administrator.myapplication.R;

/**
 * Created by 董豪华 on 2017/1/3.
 */
public class BitmapCache implements ImageLoader.ImageCache {
    private LruCache<String, Bitmap> mMemoryCache;
    BitmapCache(){
        final int cacheSize = 1024 * 1024 *  16;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return mMemoryCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mMemoryCache.put(url,bitmap);
    }
    public void setImageLoader(String url, ImageView imageView) {
        ImageLoader loader = new ImageLoader(PeiZhiActivity.mrequestQueue, new BitmapCache());
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        loader.get(url, imageListener);
    }
}
