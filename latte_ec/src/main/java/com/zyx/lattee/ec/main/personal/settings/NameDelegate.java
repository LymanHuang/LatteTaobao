package com.zyx.lattee.ec.main.personal.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.lattee.ec.R;

/**
 * Created by zyx on 2017/9/4.
 */

public class NameDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_name;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
