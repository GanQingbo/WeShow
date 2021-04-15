package com.gqb.auth.feign;

import com.gqb.auth.entity.User;
import com.gqb.auth.entity.vo.UserLoginVo;
import com.gqb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GanQingbo
 * @Classname UserFeign
 * @Description
 * @date 2021/4/13 20:39
 */
@FeignClient("weshow-service-user")
public interface UserFeign {
    @PostMapping("/user/createUser")
    R createUser(@RequestBody User user);

    @GetMapping("/user/getUserByUsername/{username}")
    R getUserByUsername(@PathVariable("username") String username);

    @GetMapping("/user/getUserByPhone/{phone}")
    R getUserByPhone(@PathVariable("phone") String phone);

    @PostMapping("/user/userLogin")
    R userLogin(@RequestBody UserLoginVo userLoginVo);
}
