package com.zyx.latte.net.rx;

import android.content.Context;

import com.zyx.latte.net.RestClient;
import com.zyx.latte.net.RestCreator;
import com.zyx.latte.net.callback.IError;
import com.zyx.latte.net.callback.IFailure;
import com.zyx.latte.net.callback.IRequest;
import com.zyx.latte.net.callback.ISuccess;
import com.zyx.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by zyx on 2017/8/8.
 */

public class RxRestClientBuilder {

    private  String mUrl = null;
    private WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private  RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;


    RxRestClientBuilder(){
    }

    public final RxRestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value){
       PARAMS.put(key,value);
        return this;
    }

    public final RxRestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }

    public final RxRestClientBuilder file(String file){
        this.mFile = new File(file);
        return this;
    }



    public final RxRestClientBuilder raw(String raw){
        this.mBody  = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }



    public final RxRestClientBuilder loader(Context context, LoaderStyle style){
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }


    public final RxRestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallSpinFadeLoaderIndicator;
        return this;
    }
    public final RxRestClient build(){
        return  new RxRestClient(mUrl,PARAMS,mBody,mFile,mContext,mLoaderStyle);
    }
}
