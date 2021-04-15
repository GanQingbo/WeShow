package com.gqb.auth.controller;

import cn.hutool.crypto.SecureUtil;
import com.gqb.auth.entity.User;
import com.gqb.auth.entity.vo.UserRegisterVo;
import com.gqb.auth.feign.UserFeign;
import com.gqb.auth.service.SmsService;
import com.gqb.common.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname RegisterController
 * @Description
 * @date 2021/4/13 20:29
 */
@RestController
@RequestMapping("/auth")
public class RegisterController {
    @Resource
    private SmsService sms;

    @Resource
    private UserFeign userFeign;

    @PostMapping("/register")
    public R userRegister(@RequestBody UserRegisterVo vo){
        boolean isCode = sms.checkCode(vo);
        if(isCode){
            R byUsername = userFeign.getUserByUsername(vo.getUsername());
            R byPhone = userFeign.getUserByPhone(vo.getMobile());
            if(byUsername.getSuccess()){
                //用户名重复了
                return R.error().code(411).message("用户名已被注册");
            }
            if(byPhone.getSuccess()){
                return R.error().code(412).message("手机号已被注册");
            }
            User user=new User();
            user.setUsername(vo.getUsername());
            //密码加密
            user.setPassword(SecureUtil.md5(vo.getPassword()));
            user.setMobile(vo.getMobile());
            user.setNickname("WeShow用户"+vo.getMobile());
            //默认头像
            user.setHeader("https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/userDefault.jpg");
            //校验通过，执行Feign接口生成用户
            R feignUser = userFeign.createUser(user);
            if(feignUser.getSuccess()){
                return R.ok().message("用户注册成功");
            }else {
                return R.error().code(413).message("用户注册服务调用失败");
            }
        }
        return R.error().code(414).message("验证码错误或已过期");
    }
}
