package com.gqb.other.controller;

import cn.hutool.core.util.RandomUtil;
import com.gqb.common.utils.R;
import com.gqb.other.service.SmsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author GanQingbo
 * @Classname SmsController
 * @Description
 * @date 2021/4/13 19:00
 */
@RestController
@RequestMapping("/other/sms")
public class SmsController {
    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @GetMapping("/getCode/{phone}")
    public R getCode(@PathVariable("phone") String phone){
        String code=redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            String str=phone+":验证码还未过期";
            return R.error().message(str);
        }
        //生成验证码
        code = RandomUtil.randomNumbers(6);
        HashMap<String,Object> param=new HashMap<>();
        param.put("code",code);
        boolean isSend = smsService.sendSms(phone, param);
        if(isSend){
            //发送成功，存到Redis3分钟
            redisTemplate.opsForValue().set("sms:"+phone,code,5, TimeUnit.MINUTES);
            return R.ok().message(phone+":发送成功");
        }
        return R.error().message("发送失败");
    }
}
