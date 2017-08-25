package com.zyx.latte.ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by zyx on 2017/8/12.
 */

public class HolderCreator implements CBViewHolderCreator<ImageHolder>{


    @Override
    public ImageHolder createHolder() {
        return new ImageHolder();
    }
}
