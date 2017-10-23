package com.zyx.lattee.ec.main.cart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.zyx.latte_ui.recycler.DataConverter;
import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;

import java.util.ArrayList;

/**
 * Created by zyx on 2017/8/23.
 */

public class ShopCartDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEmity> convert() {
        final ArrayList<MultipleItemEmity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");

        final int size = dataArray.size();
        for (int i = 0; i < size; i++){
            final JSONObject data = dataArray.getJSONObject(i);
            final String thumb  = data.getString("thumb");
            final String desc = data.getString("desc");
            final String title = data.getString("title");
            final int id = data.getInteger("id");
            final int count = data.getInteger("count");
            final double price = data.getDouble("price");

            final MultipleItemEmity entity = MultipleItemEmity.builder()
                    .setField(MultipleFields.ITEM_TYPE,ShopCartItemType.SHOP_CART_ITEM)
                    .setField(MultipleFields.ID,id)
                    .setField(MultipleFields.IMAGE_URL,thumb)
                    .setField(ShopCartItemFields.TITLE,title)
                    .setField(ShopCartItemFields.DESC,desc)
                    .setField(ShopCartItemFields.COUNT,count)
                    .setField(ShopCartItemFields.PRICE,price)
                    .setField(ShopCartItemFields.IS_SELECTED,false)
                    .setField(ShopCartItemFields.POSITION,i)
                    .build();
            dataList.add(entity);
        }
        return dataList;
    }
}
