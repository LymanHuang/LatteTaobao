package com.zyx.lattee.ec.main.personal.address;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyx.latte_ui.recycler.DataConverter;
import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/10.
 */

public class AddressDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEmity> convert() {
        final JSONArray array = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = array.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = array.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");
            final String phone = data.getString("phone");
            final String address = data.getString("address");
            final boolean isDefault = data.getBoolean("default");

            final MultipleItemEmity entity = MultipleItemEmity.builder()
                    .setItemType(AddressItemType.ITEM_ADDRESS)
                    .setField(MultipleFields.ID, id)
                    .setField(MultipleFields.NAME, name)
                    .setField(MultipleFields.TAG, isDefault)
                    .setField(AddressItemFields.ADDRESS, address)
                    .setField(AddressItemFields.PHONE, phone)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }
}
