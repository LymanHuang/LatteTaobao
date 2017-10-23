package com.zyx.latte.wechat.template;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.zyx.latte.activies.ProxyActivity;
import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.wechat.BaseWXActivity;
import com.zyx.latte.wechat.BaseWXEntryActivity;
import com.zyx.latte.wechat.LatteWeChat;

/**
 * Created by zyx on 2017/8/18.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //取消finish动画
        overridePendingTransition(0,0);
    }


    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
