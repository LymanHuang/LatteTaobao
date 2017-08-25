package com.zyx.latte.net.rx;

import android.support.annotation.NonNull;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.util.storage.LattePreference;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zyx on 2017/8/21.
 */

public final class AddCookieInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        final Request.Builder builder = chain.request().newBuilder();
        Observable.just(LattePreference.getCustomAppProfile("cookie"))
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) throws Exception {
                     //给原生api请求附带webview拦截下来的cookie
                        builder.addHeader("Cookie",cookie);
                    }
                });
        return chain.proceed(builder.build());
    }
}
