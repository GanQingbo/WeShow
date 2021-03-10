package com.gqb.user.controller;

import com.gqb.common.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author GanQingbo
 * @Classname LoginController
 * @Description
 * @date 2021/3/3 0:07
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class LoginController {
    //login
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }
    //info
    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/default.jpg");
    }
}
