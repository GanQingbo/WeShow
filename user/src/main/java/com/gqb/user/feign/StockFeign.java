package com.gqb.user.feign;

import com.gqb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GanQingbo
 * @Classname StockFeign
 * @Description
 * @date 2021/4/23 20:57
 */
@FeignClient("weshow-service-stock")
public interface StockFeign {
    @GetMapping("/ticket/getShowId/{id}")
    R getShowIdByTicketId(@PathVariable("id") Long id);
}
