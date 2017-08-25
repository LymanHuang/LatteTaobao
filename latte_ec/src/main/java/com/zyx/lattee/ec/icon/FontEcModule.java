package com.zyx.lattee.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by zyx on 2017/8/7.
 */

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "icfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
