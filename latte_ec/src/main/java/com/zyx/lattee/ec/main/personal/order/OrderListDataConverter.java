package com.zyx.lattee.ec.main.personal.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyx.latte_ui.recycler.DataConverter;
import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;

import java.util.ArrayList;

/**
 * Created by zyx on 2017/9/2.
 */

public class OrderListDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEmity> convert() {

        final JSONArray array = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = array.size();
        for (int i = 0; i < size; i++){
            final JSONObject data = array.getJSONObject(i);
            final String thumb = data.getString("thumb");
            final String title = data.getString("title");
            final int id = data.getInteger("id");
            final double price = data.getDouble("price");
            final String time = data.getString("time");

            final MultipleItemEmity entity = MultipleItemEmity.builder()
                    .setItemType(OrderListItemType.ITEM_ORDER_LIST)
                    .setField(MultipleFields.ID,id)
                    .setField(MultipleFields.IMAGE_URL,thumb)
                    .setField(MultipleFields.TITLE,title)
                    .setField(OrderItemFields.PRICE,price)
                    .setField(OrderItemFields.TIME,time)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
