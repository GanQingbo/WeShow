package com.gqb.stock.feign;

import com.gqb.common.utils.R;
import com.gqb.stock.entity.vo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-04-21 16:10
 **/
@FeignClient("weshow-service-order")
public interface OrderFeign {
    @GetMapping("/order/getOrderById/{id}")
    R getOrderById(@PathVariable("id") Long id);
    @PostMapping("/order/setOrderStatus")
    R setOrderStatus(@RequestBody Order order);
}
