package com.zyx.lattee.ec.main.index.search;

import com.alibaba.fastjson.JSONArray;
import com.zyx.latte.util.storage.LattePreference;
import com.zyx.latte_ui.recycler.DataConverter;
import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;

import java.util.ArrayList;

/**
 * Created by zyx on 2017/9/13.
 */

public class SearchDataConverter extends DataConverter {

    public static final String TAG_SEARCH_HISTORY = "search_history";

    @Override
    public ArrayList<MultipleItemEmity> convert() {
        final String jsonStr =
                LattePreference.getCustomAppProfile(TAG_SEARCH_HISTORY);
        if (!jsonStr.equals("")) {
            final JSONArray array = JSONArray.parseArray(jsonStr);
            final int size = array.size();
            for (int i = 0; i < size; i++){
                final String historyItemText  = array.getString(i);
                final MultipleItemEmity entity =  MultipleItemEmity.builder()
                        .setItemType(SearchItemType.ITEM_SEARCH)
                        .setField(MultipleFields.TEXT,historyItemText)
                        .build();
                ENTITIES.add(entity);
            }
        }
        return ENTITIES;
    }
}