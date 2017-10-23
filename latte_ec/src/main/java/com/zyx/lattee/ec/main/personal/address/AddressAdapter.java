package com.zyx.lattee.ec.main.personal.address;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.zyx.latte_ui.recycler.MultipleFields;
import com.zyx.latte_ui.recycler.MultipleItemEmity;
import com.zyx.latte_ui.recycler.MultipleRecyclerAdapter;
import com.zyx.latte_ui.recycler.MultipleViewHolder;
import com.zyx.lattee.ec.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10.
 */

public class AddressAdapter extends MultipleRecyclerAdapter {
    protected AddressAdapter(List<MultipleItemEmity> data) {
        super(data);
        addItemType(AddressItemType.ITEM_ADDRESS, R.layout.item_address);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEmity entity) {
        super.convert(holder, entity);
        switch (holder.getItemViewType()) {
            case AddressItemType.ITEM_ADDRESS:
                final String name = entity.getField(MultipleFields.NAME);
                final String phone = entity.getField(AddressItemFields.PHONE);
                final String address = entity.getField(AddressItemFields.ADDRESS);
                final boolean isDefault = entity.getField(MultipleFields.TAG);
                final int id = entity.getField(MultipleFields.ID);

                final AppCompatTextView nameText = holder.getView(R.id.tv_address_name);
                final AppCompatTextView phoneText = holder.getView(R.id.tv_address_phone);
                final AppCompatTextView addressText = holder.getView(R.id.tv_address_address);
                final AppCompatTextView deleteTextView = holder.getView(R.id.tv_address_delete);
                deleteTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                nameText.setText(name);
                phoneText.setText(phone);
                addressText.setText(address);
                break;
            default:
                break;
        }
    }
}
