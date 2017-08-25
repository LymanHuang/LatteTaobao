package com.zyx.lattee.ec.main.sort.list;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyx.latte.ui.recycler.DataConverter;
import com.zyx.latte.ui.recycler.ItemType;
import com.zyx.latte.ui.recycler.MultipleFields;
import com.zyx.latte.ui.recycler.MultipleItemEmity;

import java.util.ArrayList;

/**
 * Created by zyx on 2017/8/15.
 */

public final class VerticalListDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEmity> convert() {
        final ArrayList<MultipleItemEmity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON
                .parseObject(getJsonData())
                .getJSONObject("data")
                .getJSONArray("list");
        final int size = dataArray.size();
        for (int i= 0;i<size;i++){
            final JSONObject data =dataArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");

            final MultipleItemEmity entity = MultipleItemEmity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.VERTICAL_MENU_LIST)
                    .setField(MultipleFields.ID,id)
                    .setField(MultipleFields.TEXT,name)
                    .setField(MultipleFields.TAG,false)
                    .build();

            dataList.add(entity);
            //设置第一个被选中
            dataList.get(0).setField(MultipleFields.TAG,true);
        }
        return dataList;
    }
}
