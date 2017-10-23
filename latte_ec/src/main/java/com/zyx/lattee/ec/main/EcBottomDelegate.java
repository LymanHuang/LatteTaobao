package com.zyx.lattee.ec.main;

import android.graphics.Color;

import com.zyx.latte.delegates.bottom.BaseBottomDelegate;
import com.zyx.latte.delegates.bottom.BottomItemDelegate;
import com.zyx.latte.delegates.bottom.BottomTabBean;
import com.zyx.latte.delegates.bottom.ItemBuilder;
import com.zyx.lattee.ec.main.cart.ShopCartDelegate;
import com.zyx.lattee.ec.main.discover.DiscoverDelegate;
import com.zyx.lattee.ec.main.index.IndexDelegate;
import com.zyx.lattee.ec.main.personal.PersonalDelegate;
import com.zyx.lattee.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by zyx on 2017/8/11.
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
            items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
            items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
            items.put(new BottomTabBean("{fa-compass}", "发现"), new DiscoverDelegate());
            items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new ShopCartDelegate());
            items.put(new BottomTabBean("{fa-user}", "我的"), new PersonalDelegate());

        return builder.addItem(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
