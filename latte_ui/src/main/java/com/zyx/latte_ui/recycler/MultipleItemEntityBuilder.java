package com.zyx.latte_ui.recycler;



import java.util.LinkedHashMap;
import java.util.WeakHashMap;

/**
 * Created by zyx on 2017/8/11.
 */

public class MultipleItemEntityBuilder {

    private static final LinkedHashMap<Object,Object> FIELDS = new LinkedHashMap<>();

    public MultipleItemEntityBuilder(){
        //先清除之前的数据
        FIELDS.clear();
    }

    public final MultipleItemEntityBuilder setItemType(int itemType){
        FIELDS.put(MultipleFields.ITEM_TYPE,itemType);
        return this;
    }

    public final MultipleItemEntityBuilder setField(Object key,Object value){
        FIELDS.put(key,value);
        return this;
    }

    public final MultipleItemEntityBuilder setFields(WeakHashMap<?,?> map){
        FIELDS.putAll(map);
        return this;
    }

    public final MultipleItemEmity build(){
       return new MultipleItemEmity(FIELDS);
    }
}
