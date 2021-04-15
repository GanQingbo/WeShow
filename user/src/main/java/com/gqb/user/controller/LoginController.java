package com.gqb.user.controller;

import com.gqb.common.utils.JwtUtils;
import com.gqb.common.utils.R;
import com.gqb.user.entity.User;
import com.gqb.user.entity.vo.UserLoginVo;
import com.gqb.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author GanQingbo
 *
 *
 * @Classname LoginController
 * @Description
 * @date 2021/3/3 0:07
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Resource
    UserService userService;

    /**
     * 后台登录
     * @return
     */
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }
    //info
    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://weshow-bucket.oss-cn-guangzhou.aliyuncs.com/avatar/default.jpg");
    }

    /**
     * 用户登录
     * @param userLoginVo
     * @return
     */
    @PostMapping("/userLogin")
    public R userLogin(@RequestBody UserLoginVo userLoginVo){
        System.out.println("UserLogin:"+userLoginVo.getUsername());
        User user= userService.login(userLoginVo);
        if(user!=null){
            if(user.getStatus()==0){
                return R.error().message("账号被禁用");
            }
            String token = JwtUtils.getJwtToken(user.getId().toString(), user.getNickname());
            return R.ok().data("user",user).data("token",token);
        }
        return R.error().message("用户名或密码错误");
    }

    /**
     * 根据token获取用户信息
     * @param request
     * @return
     */
    @GetMapping("/getUserInfo")
    public R getUserInfoByToken(HttpServletRequest request){
        String userId = JwtUtils.getUserIdByToken(request);
        User user = userService.getUserById(Long.valueOf(userId));
        if(user!=null){
            return R.ok().data("user",user);
        }
        return R.error().message("获取用户信息失败");
    }
}
