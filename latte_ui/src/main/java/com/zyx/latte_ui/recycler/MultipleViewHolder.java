package com.zyx.latte_ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by zyx on 2017/8/12.
 */

public class MultipleViewHolder  extends BaseViewHolder{
    public MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder create(View view){
        return new MultipleViewHolder(view);
    }
}
