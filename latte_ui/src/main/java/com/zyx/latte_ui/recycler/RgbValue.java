package com.zyx.latte_ui.recycler;

import com.google.auto.value.AutoValue;

/**
 * Created by zyx on 2017/8/14.
 */
@AutoValue
public abstract class RgbValue {
    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbValue create(int red, int green, int blue) {
        return new AutoValue_RgbValue(red, green, blue);
    }


}

