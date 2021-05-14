package com.gqb.user.controller;

import com.gqb.common.utils.R;
import com.gqb.user.entity.Identity;
import com.gqb.user.entity.Order;
import com.gqb.user.entity.TicketSell;
import com.gqb.user.entity.vo.IdentityCheckVo;
import com.gqb.user.service.IdentityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname IdentityController
 * @Description
 * @date 2021/4/23 18:46
 */
@RestController
@RequestMapping("/user")
public class IdentityController {
    @Resource
    private IdentityService identityService;

    @GetMapping("/getIdentityByUser/{id}")
    public R getIdentityByUser(@PathVariable("id") Long id){
        List<Identity> identityByUser = identityService.getIdentityByUser(id);
        if(identityByUser.size()!=0 && !identityByUser.isEmpty()){
            return R.ok().data("identity",identityByUser);
        }
        return R.error();
    }

    @PostMapping("/createIdentity")
    public R createIdentity(@RequestBody Identity identity){
        int identity1 = identityService.createIdentity(identity);
        if(identity1>0){
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping("/deleteIdentity/{id}")
    public R deleteIdentity(@PathVariable("id") Long id){
        int i = identityService.deleteIdentityById(id);
        if (i>0){
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/identityCheck")
    public R identityCheck(@RequestBody IdentityCheckVo identityCheckVo){
        boolean b = identityService.identityCheck(identityCheckVo);
        if(b==false){
            return R.ok().message("无查询记录");
        }
        return R.error().message("重复购票");
    }

    @PostMapping("/addTicketSell")
    public R addTicketSell(@RequestBody IdentityCheckVo identityCheckVo){
        int i = identityService.addTicketSell(identityCheckVo);
        if(i>=0){
            return R.ok().message("添加关系成功");
        }
        return R.error();
    }

    //删除售票记录
    @PostMapping("/returnTicket")
    public R returnTicket(@RequestBody Order order){
        int i = identityService.deleteTicketSell(order);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }
}
