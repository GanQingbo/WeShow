package com.gqb.order.client;

import com.gqb.common.utils.R;
import com.gqb.order.entity.vo.TicketLockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

/**
 * @author GanQingbo
 * @Classname StockClient
 * @Description openfeign调用stock的接口
 * @date 2021/3/15 13:19
 */
@FeignClient("weshow-service-stock")
@Component
public interface StockClient {
    //出票
    @PostMapping("/ticket/sellTicket/{id}")
    R sellTicket(@PathVariable(value = "id") Long id);
    //获取票的信息
    @GetMapping("/ticket/getTicketById/{id}")
    R getTicketById(@PathVariable(value = "id") Long id);
    //票的价格
    @GetMapping("/ticket/getPriceById/{id}")
    BigDecimal getPriceById(@PathVariable(value = "id") Long id);
    //剩余票数
    @GetMapping("/ticket/getSurplusById/{id}")
    Integer getSurplusById(@PathVariable(value = "id") Long id);
    //获取演出id
    @GetMapping("/ticket/getShowId/{id}")
    R getShowIdByTicketId(@PathVariable("id") Long id);
    //锁定库存
    @PostMapping("/ticket/ticketLocked")
    public R ticketLocked(@RequestBody TicketLockVo ticketLockVo);
}
