package com.gqb.order.client;

import com.gqb.common.utils.R;
import com.gqb.order.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author GanQingbo
 * @Classname UserFeign
 * @Description
 * @date 2021/4/23 23:57
 */
@FeignClient("weshow-service-user")
public interface UserFeign {
    @PostMapping("/user/returnTicket")
    R returnTicket(@RequestBody Order order);
}
