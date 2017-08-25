package com.zyx.learnexample.generators;

import com.example.annotations.PayEntryGenerator;
import com.zyx.latte.wechat.template.WPayXEntryTemplate;


/**
 * Created by zyx on 2017/8/18.
 */
@PayEntryGenerator(
        packageName = "com.zyx.learnexample",
        payEntryTemplete =WPayXEntryTemplate.class
)
public interface WeChatPayEntry {
}
