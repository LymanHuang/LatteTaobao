package com.zyx.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zyx.latte.ui.image.GlideApp;

/**
 * Created by zyx on 2017/8/12.
 */

public class ImageHolder implements Holder<String>{

    private AppCompatImageView mImageview = null;

    @Override
    public View createView(Context context) {
        mImageview = new AppCompatImageView(context);
        return mImageview;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        GlideApp.with(context)
                .load(data)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .centerCrop()
                .into(mImageview);

    }
}
