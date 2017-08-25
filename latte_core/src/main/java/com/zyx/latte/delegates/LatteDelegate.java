package com.zyx.latte.delegates;

/**
 * Created by zyx on 2017/8/7.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {

    public <T extends LatteDelegate> T getParentDelegate(){
        return (T) getParentFragment();
    }
}
