package com.gqb.show.feign;

import com.gqb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GanQingbo
 * @Classname OrderFeign
 * @Description
 * @date 2021/4/16 13:52
 */
@FeignClient("weshow-service-order")
public interface OrderFeign {
    /**
     * 根据用户id获取演出id
     */
    @GetMapping("/order/getShowsByUserId/{id}")
    R getShowsByUserId(@PathVariable("id") Long id);
}
