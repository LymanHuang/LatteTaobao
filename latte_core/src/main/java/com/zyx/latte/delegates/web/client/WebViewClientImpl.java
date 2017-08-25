package com.zyx.latte.delegates.web.client;

import android.graphics.Bitmap;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zyx.latte.app.ConfigKeys;
import com.zyx.latte.app.Latte;
import com.zyx.latte.delegates.IPageLoadListener;
import com.zyx.latte.delegates.web.WebDelegate;
import com.zyx.latte.ui.LatteLoader;
import com.zyx.latte.util.storage.LattePreference;

/**
 * Created by zyx on 2017/8/19.
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;

    public void setPageLoadListener(IPageLoadListener listener){
        this.mIPageLoadListener = listener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return Router.getInstance().handleWebUrl(DELEGATE,url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null){
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
       // syncCookie();
        if (mIPageLoadListener!=null){
            mIPageLoadListener.onLoadEnd();
        }
        LatteLoader.stopLoading();
    }

    //获取浏览器的cookie
    private void syncCookie(){
        final CookieManager manager = CookieManager.getInstance();
        /*
        注意，这里的cookieh和api请求的cookie是不一样的，这个在网页不可见
         */
        final String webhost = Latte.getConfiguration(ConfigKeys.WEB_HOST);
        if (webhost!= null){
            if (manager.hasCookies()){
                final String cookieStr = manager.getCookie(webhost);
                if (cookieStr!=null&&!cookieStr.equals("")){
                    LattePreference.addCustomAppProfile("cookie",cookieStr);
                }
            }
        }
    }
}
