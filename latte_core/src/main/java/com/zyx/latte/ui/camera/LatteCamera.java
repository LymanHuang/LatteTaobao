package com.zyx.latte.ui.camera;

import android.net.Uri;

import com.zyx.latte.delegates.PermissionCheckerDelegate;
import com.zyx.latte.util.FileUtil;

/**
 * Created by zyx on 2017/9/4.
 * 照相机调用类
 */

public class LatteCamera {
    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}

