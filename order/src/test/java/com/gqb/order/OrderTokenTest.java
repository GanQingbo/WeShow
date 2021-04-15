package com.gqb.order;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.gqb.order.entity.vo.ConfirmVo;
import com.gqb.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname OrderTokenTest
 * @Description
 * @date 2021/4/15 19:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTokenTest {
    @Resource
    OrderService orderService;

    @Test
    public void tokenTest(){
        ConfirmVo confirmVo=new ConfirmVo();
        String orderToken = orderService.getOrderToken(1L);
        confirmVo.setUserId(1L);
        confirmVo.setToken(orderToken);
        orderService.orderConfirm(confirmVo);
    }

    @Test
    public void SnowTest(){
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        Long orderSn = snowflake.nextId();
        System.out.println("=====订单号：" + orderSn);
    }
}
