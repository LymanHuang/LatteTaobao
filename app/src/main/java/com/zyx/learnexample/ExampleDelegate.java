package com.zyx.learnexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.wang.avi.AVLoadingIndicatorView;
import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.net.RestClient;
import com.zyx.latte.net.callback.IError;
import com.zyx.latte.net.callback.IFailure;
import com.zyx.latte.net.callback.ISuccess;

/**
 * Created by zyx on 2017/8/7.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
           testRestClient();
    }

    public void testRestClient(){
        RestClient.builder()
                .url("http://www.baidu.com/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(),response,Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
