package com.gqb.auth.feign;

import com.gqb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author GanQingbo
 * @Classname SmsFeign
 * @Description
 * @date 2021/4/13 19:39
 */
@FeignClient("weshow-service-other")
public interface SmsFeign {
    @GetMapping("/other/sms/getCode/{phone}")
    R getCode(@PathVariable("phone") String phone);
}
