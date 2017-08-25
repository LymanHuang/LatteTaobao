package com.zyx.learnexample.generators;


import com.example.annotations.AppRegisterGenerator;
import com.zyx.latte.wechat.template.AppRegisterTemplate;
import com.zyx.latte.wechat.template.WPayXEntryTemplate;

/**
 * Created by zyx on 2017/8/18.
 */
@AppRegisterGenerator(
        packageName = "com.zyx.learnexample",
        registerTemplate =AppRegisterTemplate.class
)
public interface AppRegister {
}
