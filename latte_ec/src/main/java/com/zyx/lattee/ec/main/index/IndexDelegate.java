package com.zyx.lattee.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.joanzapata.iconify.widget.IconTextView;
import com.zyx.latte.delegates.bottom.BottomItemDelegate;
import com.zyx.latte.ui.recycler.BaseDecoration;
import com.zyx.latte.ui.recycler.MultipleFields;
import com.zyx.latte.ui.recycler.MultipleItemEmity;
import com.zyx.latte.ui.refresh.RefreshHandler;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;
import com.zyx.lattee.ec.main.EcBottomDelegate;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by zyx on 2017/8/11.
 */

public class IndexDelegate extends BottomItemDelegate {
    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerview = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;

    private RefreshHandler mRefreshHandler = null;
    private void initRefreshLayout(){
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        //测试用的临时域名
        mRefreshHandler.firstPage("http://www.youec.cc/apptest/index.php");
    }

    private void initRecyclerView(){
        final GridLayoutManager manager = new GridLayoutManager(getContext(),4);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.addItemDecoration(BaseDecoration.create(ContextCompat.getColor(getContext(),
                R.color.app_background),5));
         final EcBottomDelegate ecBottomDelegate  = getParentDelegate();
         mRecyclerview.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
       mRefreshHandler = RefreshHandler.create(mRefreshLayout,mRecyclerview,new IndexDataConverter(),getContext());
    }
}
