package com.zyx.lattee.ec.main.personal.order;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.util.Callback.CallbackManager;
import com.zyx.latte.util.Callback.CallbackType;
import com.zyx.latte.util.Callback.IGlobalCallback;
import com.zyx.latte_ui.widget.AutoPhotoLayout;
import com.zyx.latte_ui.widget.StarLayout;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zyx on 2017/9/14.
 */

public class OrderCommentDelegate extends LatteDelegate {
    @BindView(R2.id.custom_star_layout)
    StarLayout mStarLayout = null;
    @BindView(R2.id.custom_auto_photo_layout)
    AutoPhotoLayout mAutoPhotoLayout = null;

    @OnClick(R2.id.top_tv_comment_commit)
    void onClickSubmit() {
        Toast.makeText(getContext(), "评分:" + mStarLayout.getStarCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_order_comment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mAutoPhotoLayout.setDelegate(this);
        CallbackManager.getInstance()
                .addCallback(CallbackType.ON_CROP, new IGlobalCallback<Uri>() {
                    @Override
                    public void executeCallback(Uri args) {
                        mAutoPhotoLayout.onCropTarget(args);
                    }
                });
    }
}
