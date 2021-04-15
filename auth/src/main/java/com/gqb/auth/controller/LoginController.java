package com.gqb.auth.controller;

import com.gqb.auth.entity.vo.UserLoginVo;
import com.gqb.auth.feign.UserFeign;
import com.gqb.common.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname LoginController
 * @Description
 * @date 2021/4/13 19:47
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
    @Resource
    UserFeign userFeign;

    @PostMapping("/login")
    public R userLogin(@RequestBody UserLoginVo userLoginVo){
        System.out.println("UserLogin:"+userLoginVo.getUsername());
        R r = userFeign.userLogin(userLoginVo);
        return r;
    }
}
