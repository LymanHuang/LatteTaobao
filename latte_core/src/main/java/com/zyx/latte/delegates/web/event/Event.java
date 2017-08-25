package com.zyx.latte.delegates.web.event;

import android.content.Context;
import android.webkit.WebView;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.delegates.web.WebDelegate;

/**
 * Created by zyx on 2017/8/19.
 */

public abstract class Event implements IEvent {
    private Context mContext = null;
    private String mAction = null;
    private WebDelegate mDelegate  = null;
    private String mUrl = null;
    private WebView mWebView = null;

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public WebView getWebView() {
        return mWebView;
    }

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        this.mAction = action;
    }

    public WebDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(WebDelegate delegate) {
        this.mDelegate = delegate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
