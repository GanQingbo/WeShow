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
public class R0 extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public R0 setData(Object data){
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

    public R0 put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    //构造方法
    public R0() {
        put("code", 200);
        put("message", "success");
    }

    //静态成功/失败方法
    public static R0 ok() {
        return new R0();
    }

    //返回指定消息
    public static R0 ok(String msg) {
        R0 r = new R0();
        r.put("message", msg);
        return r;
    }

    //返回1个或多个对象
    public static R0 ok(Map<String, Object> map) {
        R0 r = new R0();
        r.putAll(map);
        return r;
    }

    public static R0 error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知错误");
    }

    public static R0 error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R0 error(int code, String msg) {
        R0 r = new R0();
        r.put("code", code);
        r.put("message", msg);
        return r;
    }

}
