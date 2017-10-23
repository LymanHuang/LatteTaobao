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
import com.zyx.latte_ui.recycler.BaseDecoration;
import com.zyx.latte_ui.refresh.RefreshHandler;
import com.zyx.latte_ui.refresh.RefreshYield;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;
import com.zyx.lattee.ec.main.EcBottomDelegate;
import com.zyx.lattee.ec.main.index.search.SearchDelegate;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by zyx on 2017/8/11.
 */

public class IndexDelegate extends BottomItemDelegate implements View.OnFocusChangeListener {
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

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true, 120, 300);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerView();
        //测试用的临时域名
        mRefreshHandler.setRefreshYield("http://www.youec.cc/apptest/index.php", "page_size", "total");
        mRefreshHandler.firstPage();
    }

    private void initRecyclerView() {
        final GridLayoutManager manager = new GridLayoutManager(getContext(), 4);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.addItemDecoration(BaseDecoration.create(ContextCompat.getColor(getContext(),
                R.color.app_background), 5));
        final EcBottomDelegate ecBottomDelegate = getParentDelegate();
        mRecyclerview.addOnItemTouchListener(IndexItemClickListener.create(ecBottomDelegate));
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = RefreshHandler.create(mRefreshLayout, mRecyclerview, new IndexDataConverter(), getContext());
        mSearchView.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            getParentDelegate().getSupportDelegate().start(new SearchDelegate());
        }
    }
}
