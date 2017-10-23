package com.zyx.lattee.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.zyx.latte.delegates.bottom.BottomItemDelegate;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.main.sort.content.ContentDelegate;
import com.zyx.lattee.ec.main.sort.list.VerticalListDelegate;

/**
 * Created by zyx on 2017/8/11.
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        Log.d("Sort", "Onbind");
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container, listDelegate);
        //设置右侧第一个分类显示,默认显示分类一
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
        Log.d("sort", "OnLazy");

    }
}
