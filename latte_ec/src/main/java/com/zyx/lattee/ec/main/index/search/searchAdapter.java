package com.zyx.lattee.ec.main.index.search;

import android.support.v7.widget.AppCompatTextView;

import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;
import com.zyx.latte_ui.recycler.MultipleRecyclerAdapter;
import com.zyx.latte_ui.recycler.MultipleViewHolder;
import com.zyx.lattee.ec.R;

import java.util.List;

/**
 * Created by zyx on 2017/9/13.
 */

public class searchAdapter extends MultipleRecyclerAdapter {
    protected searchAdapter(List<MultipleItemEmity> data) {
        super(data);
        addItemType(SearchItemType.ITEM_SEARCH, R.layout.item_search);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEmity entity) {
        super.convert(holder, entity);
        switch (entity.getItemType()) {
            case SearchItemType.ITEM_SEARCH:
                final AppCompatTextView tvSearchItem = holder.getView(R.id.tv_search_item);
                final String history = entity.getField(MultipleFields.TEXT);
                tvSearchItem.setText(history);
                break;
            default:
                break;
        }
    }
}
