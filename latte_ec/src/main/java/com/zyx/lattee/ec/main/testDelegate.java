package com.zyx.lattee.ec.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.zyx.latte.delegates.bottom.BottomItemDelegate;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;

import butterknife.BindView;

/**
 * Created by zyx on 2017/9/26.
 */

public class testDelegate extends BottomItemDelegate {
    @BindView(R2.id.test_btn)
    Button test_btn;
    @Override
    public Object setLayout() {
        return R.layout.delegate_test;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
