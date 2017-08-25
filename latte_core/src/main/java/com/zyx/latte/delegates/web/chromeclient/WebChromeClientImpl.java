package com.zyx.latte.delegates.web.chromeclient;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by zyx on 2017/8/19.
 */

public class WebChromeClientImpl extends WebChromeClient {

    //拦截alertdialog事件
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
    }
}
