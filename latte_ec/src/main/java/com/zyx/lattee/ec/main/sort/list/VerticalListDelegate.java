package com.zyx.lattee.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.net.RestClient;
import com.zyx.latte.net.callback.ISuccess;
import com.zyx.latte.ui.recycler.MultipleItemEmity;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;
import com.zyx.lattee.ec.main.sort.SortDelegate;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zyx on 2017/8/15.
 */

public class VerticalListDelegate extends LatteDelegate {
    @BindView(R2.id.rv_vertical_menu_list)
    RecyclerView mRecyclerView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    private void initRecyclerview(){
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        //屏蔽动画效果
        mRecyclerView.setItemAnimator(null);

    }
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRecyclerview();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("http://www.youec.cc/apptest/sort_list.php")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final List<MultipleItemEmity> data =
                               new VerticalListDataConverter().setJsonData(response).convert();
                        final SortDelegate delegate = getParentDelegate();
                        final SortRecyclerAdapter adapter = new SortRecyclerAdapter(data,delegate);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .build()
                .get();
    }
}
