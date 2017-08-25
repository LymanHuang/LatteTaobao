package com.zyx.lattee.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by zyx on 2017/8/7.
 */

public enum EcIcons implements Icon {
    icon_scan('\ue609'),
    icon_ali_pay('\ue609');
    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
