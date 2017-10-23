package com.zyx.lattee.ec.detail;

import android.support.v7.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.zyx.latte_ui.recycler.ItemType;
import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;
import com.zyx.latte_ui.recycler.MultipleRecyclerAdapter;
import com.zyx.latte_ui.recycler.MultipleViewHolder;
import com.zyx.lattee.ec.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/14.
 */

public class RecylerImageAdapter extends MultipleRecyclerAdapter {
    protected RecylerImageAdapter(List<MultipleItemEmity> data) {
        super(data);
        addItemType(ItemType.SINGLE_BIG_IMAGE, R.layout.item_image);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEmity entity) {
        final int type = holder.getItemViewType();
        switch (type) {
            case ItemType.SINGLE_BIG_IMAGE:
                final AppCompatImageView imageView = holder.getView(R.id.image_rv_item);
                final String url = entity.getField(MultipleFields.IMAGE_URL);
                Glide.with(mContext)
                        .load(url)
                        .into(imageView);
                break;
            default:
                break;
        }
    }
}
