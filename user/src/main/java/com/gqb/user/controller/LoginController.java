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
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=w&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1011187524,1528767495&os=4032188260,1522454031&simid=3340924706,154932204&pn=115&rn=1&di=60610&ln=1720&fr=&fmq=1614701564864_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=3c&hs=2&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fb-ssl.duitang.com%252Fuploads%252Fitem%252F201810%252F05%252F20181005234630_wzsyu.jpg%26refer%3Dhttp%253A%252F%252Fb-ssl.duitang.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1617293568%26t%3D4751769e77955489d3fd2cc5286e52ba&rpstart=0&rpnum=0&adpicid=0&force=undefined");
    }
}
