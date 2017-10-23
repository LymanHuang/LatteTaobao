package com.zyx.latte.ui.camera;

import android.net.Uri;

/**
 * Created by zyx on 2017/9/4.
 * 存储一些中间值
 */

public class CameraImaegBean {

    private Uri mPath = null;

    private static final CameraImaegBean INSTANCE = new CameraImaegBean();

    public static CameraImaegBean getInstance(){
        return INSTANCE;
    }

    public Uri getPath() {
        return mPath;
    }

    public void setPath(Uri mPath) {
        this.mPath = mPath;
    }
}
