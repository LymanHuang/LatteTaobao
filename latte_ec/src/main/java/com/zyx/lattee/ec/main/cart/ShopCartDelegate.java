package com.zyx.lattee.ec.main.cart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.zyx.latte.delegates.LatteDelegate;
import com.zyx.latte.delegates.bottom.BottomItemDelegate;
import com.zyx.latte.net.RestClient;
import com.zyx.latte.net.callback.ISuccess;
import com.zyx.latte.ui.recycler.MultipleFields;
import com.zyx.latte.ui.recycler.MultipleItemEmity;
import com.zyx.lattee.ec.R;
import com.zyx.lattee.ec.R2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zyx on 2017/8/22.
 */

public class ShopCartDelegate extends BottomItemDelegate implements ISuccess, ICartIemListener {

    private ShopCartAdapter mAdapter = null;

    private int mIconSelectedCount = 0;


    @BindView(R2.id.rv_shop_cart)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.icon_shop_cart_select_all)
    IconTextView mIconSelectAll = null;
    @BindView(R2.id.stub_no_item)
    ViewStubCompat mStubNoItem = null;
    @BindView(R2.id.tv_shop_cart_total_price)
    AppCompatTextView mTotalPrice = null;

    @OnClick(R2.id.icon_shop_cart_select_all)
    void onClickSelectAll(){
        final int tag = (int) mIconSelectAll.getTag();
        if (tag==0){
            mIconSelectAll.setTextColor
                    (ContextCompat.getColor(getContext(),R.color.app_main));
            mIconSelectAll.setTag(1);
            mAdapter.setIsSelectedAll(true);
            //更新Recyclerview的显示状态
            mAdapter.notifyItemRangeChanged(0,mAdapter.getItemCount());
        }else {
            mIconSelectAll.setTextColor(Color.GRAY);
            mIconSelectAll.setTag(0);
            mAdapter.setIsSelectedAll(false);
            mAdapter.notifyItemRangeChanged(0,mAdapter.getItemCount());
        }
    }

    @OnClick(R2.id.tv_top_shop_cart_remove_selected)
    void onClickRemoveSelectedItem(){
        final List<MultipleItemEmity> data = mAdapter.getData();
        //要删除的数据
        final List<MultipleItemEmity> deleteEntities= new ArrayList<>();
        for (MultipleItemEmity entity : data){
            final boolean isSelected = entity.getField(ShopCartItemFields.IS_SELECTED);
            if (isSelected){
                deleteEntities.add(entity);
            }
        }

        for (int i = 0;i < deleteEntities.size();i++){
            int DataCount = data.size();
            int currentPosition = deleteEntities.get(i).getField(ShopCartItemFields.POSITION);
            if (currentPosition<data.size()){
                mAdapter.remove(currentPosition);
                for (;currentPosition < DataCount-1;currentPosition++){
                    int rawItemPos = data.get(currentPosition).getField(ShopCartItemFields.POSITION);
                    data.get(currentPosition).setField(ShopCartItemFields.POSITION,rawItemPos-1);
                }
            }
        }
        checkItemCount();
    }

    @OnClick(R2.id.tv_top_shop_cart_clear)
    void onClickClear(){
        mAdapter.getData().clear();
        mAdapter.notifyDataSetChanged();
        checkItemCount();
    }

    private void checkItemCount(){
        final int count = mAdapter.getItemCount();
        if (count == 0){
            final View stubView = mStubNoItem.inflate();
            final AppCompatTextView tvToBuy = (AppCompatTextView) stubView.findViewById(R.id.tv_stub_to_buy);
            tvToBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"你该购物啦！",Toast.LENGTH_SHORT).show();
                }
            });
            mRecyclerView.setVisibility(View.GONE);
        }else {
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public Object setLayout() {
        return R.layout.delegate_shop_cart;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
             mIconSelectAll.setTag(0);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        RestClient.builder()
                .url("http://www.youec.cc/apptest/shop_cart.php")
                .loader(getContext())
                .success(this)
                .build()
                .get();
    }

    @Override
    public void onSuccess(String response) {
        final ArrayList<MultipleItemEmity> data =
                new ShopCartDataConverter()
                .setJsonData(response)
                .convert();
        mAdapter = new ShopCartAdapter(data);
        mAdapter.setCartItemListener(this);
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        checkItemCount();
    }

    @Override
    public void onItemClick(double itemTotalPrice) {
        final double price = mAdapter.getTotalPrice();
        mTotalPrice.setText(String.valueOf(price));
    }
}
