package com.zyx.lattee.ec.pay;

/**
 * Created by zyx on 2017/8/26.
 */
public interface IAlPayResultListener {

    void onPaySuccess();

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();
}
