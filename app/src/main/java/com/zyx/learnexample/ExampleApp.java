package com.zyx.learnexample;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.zyx.latte.app.Latte;
import com.zyx.latte.delegates.web.event.UndefineEvent;
import com.zyx.latte.net.interceptors.DebugInterceptor;
import com.zyx.lattee.ec.database.DatabaseManager;
import com.zyx.lattee.ec.icon.FontEcModule;

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
                .withApiHost("http://127.0.0.1/")
                .withJavascriptInterface("latte")
                .withWebEvent("test",new UndefineEvent())
//                .withInterceptor(new DebugInterceptor("http://www.baidu.com/index",R.raw.test))
                .configure();
        DatabaseManager.getInstance().init(this);
    }
}
