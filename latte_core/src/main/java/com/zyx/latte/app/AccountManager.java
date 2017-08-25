package com.zyx.latte.app;

import com.zyx.latte.util.storage.LattePreference;

/**
 * Created by zyx on 2017/8/17.
 */

public class AccountManager {
    private enum SignTag{
        SIGN_TAG
    }

    //保存用户登录状态，登陆后调用
    public static void setSignState(boolean state){
        LattePreference.setAppFlag(SignTag.SIGN_TAG.name(),state);
    }

    //返回用户登录状态
    private static boolean isSignIn(){
        return LattePreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker){
        if (isSignIn()){
            checker.onSignIn();
        }else {
            checker.onNotSignIn();
        }
    }
}
