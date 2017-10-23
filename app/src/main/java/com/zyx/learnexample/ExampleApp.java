package com.zyx.learnexample;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zyx.latte.app.Latte;
import com.zyx.latte.delegates.web.event.UndefineEvent;
import com.zyx.latte.net.interceptors.DebugInterceptor;
import com.zyx.lattee.ec.database.DatabaseManager;
import com.zyx.lattee.ec.icon.FontEcModule;

import me.yokeyword.fragmentation.*;

/**
 * Created by zyx on 2017/8/7.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://www.youec.cc/apptest/")
                .withJavascriptInterface("latte")
                .withWebEvent("test",new UndefineEvent())
                .withWebEvent("share",new ShareEvent())
                .withWeChatAppId("")
                .withWeChatAppSecret("")
        //        .withInterceptor(new DebugInterceptor("http://www.baidu.com/index",R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);
        Fragmentation.builder()
                .debug(true)
                .stackViewMode(Fragmentation.SHAKE)
                .install();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
