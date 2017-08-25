package com.zyx.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zyx.latte.activies.ProxyActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by zyx on 2017/8/7.
 */

public abstract class BaseDelegate extends SwipeBackFragment {
        @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;
    public abstract Object setLayout();
    public abstract void onBindView(@Nullable Bundle savedInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = null;
        if (setLayout() instanceof Integer){
           rootview = inflater.inflate((Integer) setLayout(),container,false);
        }else if (setLayout() instanceof View){
            rootview = (View) setLayout();
        }
        if (rootview != null){
            mUnbinder = ButterKnife.bind(this,rootview);
            onBindView(savedInstanceState,rootview);
        }
        return rootview;
    }

    public final ProxyActivity getProxyActivity(){
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
