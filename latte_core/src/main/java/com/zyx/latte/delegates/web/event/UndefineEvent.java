package com.zyx.latte.delegates.web.event;

import android.util.Log;

/**
 * Created by zyx on 2017/8/19.
 */

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        Log.d("UndefineEvent",params);
        return null;
    }
}
