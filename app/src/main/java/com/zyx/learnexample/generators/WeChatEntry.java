package com.zyx.learnexample.generators;

import com.example.annotations.EntryGenerator;
import com.zyx.latte.wechat.template.WXEntryTemplate;

/**
 * Created by zyx on 2017/8/18.
 */

@EntryGenerator(
        packageName = "com.zyx.learnexample",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
