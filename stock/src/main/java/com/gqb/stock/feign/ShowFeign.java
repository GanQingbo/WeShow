package com.gqb.stock.feign;

import com.gqb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GanQingbo
 * @Classname ShowFegin
 * @Description
 * @date 2021/4/14 18:57
 */
@FeignClient("weshow-service-show")
public interface ShowFeign {
    @GetMapping("/getShowById/{id}")
    R getShowById(@PathVariable Long id);
}
