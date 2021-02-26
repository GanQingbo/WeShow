package com.gqb.common.utils;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GanQingbo
 * @Classname R
 * @Description 统一返回结果R，key可以是code、message、data
 * @date 2021/2/24 10:53
 */
public class R extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public R setData(Object data){
        put("data", data);
        return this;
    }

    public <T> T getData(String key, TypeReference<T> typeReference){
        // get("data") 默认是map类型 所以要由map转成string再转json
        Object data=get(key);
        return JSON.parseObject(JSON.toJSONString(data),typeReference);
    }

    public <T> T getData(TypeReference<T> typeReference){
        Object data = get("data");
        return JSON.parseObject(JSON.toJSONString(data), typeReference);
    }

    public Integer getCode() {
        return (Integer) this.get("code");
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    //构造方法
    public R() {
        put("code", 0);
        put("msg", "success");
    }

    //静态成功/失败方法
    public static R ok() {
        return new R();
    }

    //返回指定消息
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    //返回1个或多个对象
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知错误");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

}
