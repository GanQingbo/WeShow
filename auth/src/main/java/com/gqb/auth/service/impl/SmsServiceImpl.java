package com.gqb.auth.service.impl;

import com.gqb.auth.entity.vo.UserRegisterVo;
import com.gqb.auth.service.SmsService;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname SmsServiceImpl
 * @Description
 * @date 2021/4/13 20:52
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 验证码校验
     * @param vo
     * @return
     */
    @Override
    public boolean checkCode(UserRegisterVo vo) {
        String code = redisTemplate.opsForValue().get("sms:" + vo.getMobile());
        if(!StringUtils.isEmpty(code) && code.equals(vo.getCode())){
            //验证码正确，从redis中删除
            redisTemplate.delete("sms:" + vo.getMobile());
            return true;
        }
        //验证码错误或已过期
        return false;
    }
}
