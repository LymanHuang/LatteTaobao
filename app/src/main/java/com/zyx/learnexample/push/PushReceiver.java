package com.zyx.learnexample.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.fastjson.JSONObject;
import com.zyx.latte.activies.ProxyActivity;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/10/10.
 */

public class PushReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        final Bundle bundle = intent.getExtras();
        final Set<String> keys = bundle.keySet();
        final JSONObject json = new JSONObject();
        for (String key : keys) {
            final Object val = bundle.get(key);
            json.put(key, val);
        }

        final String pushAction = intent.getAction();
        if (pushAction.equals(JPushInterface.ACTION_NOTIFICATION_RECEIVED)) {
            //处理接收到的信息
            onReceivedMessage(bundle);
        } else if (pushAction.equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
            //打开相应的Notification
        }
    }

    private void onReceivedMessage(Bundle bundle) {
        final String title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
        final String msgId = bundle.getString(JPushInterface.EXTRA_MSG_ID);
        final int notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
        final String message = bundle.getString(JPushInterface.EXTRA_MESSAGE);
        final String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        final String alert = bundle.getString(JPushInterface.EXTRA_ALERT);
    }

    private void onOpenNotification(Context context, Bundle bundle) {
        final String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
        final Bundle openActivityBundle = new Bundle();
        final Intent intent = new Intent(context, ProxyActivity.class);
    }
}
