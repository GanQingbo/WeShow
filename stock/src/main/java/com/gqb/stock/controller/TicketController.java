package com.gqb.stock.controller;

import com.gqb.common.utils.R;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.service.TicketService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketController
 * @Description
 * @date 2021/3/10 10:23
 */
@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {
    @Resource
    private TicketService ticketService;

    @PostMapping("/createTicket")
    public R createTicket(@RequestBody Ticket ticket) {
        int i = ticketService.createTicket(ticket);
        if (i > 0) {
            return R.ok().data("id", ticket.getId());
        }
        return R.error().message("创建售票信息失败");
    }

    @GetMapping("/getTicketById/{id}")
    public R getTicketById(@PathVariable Long id) {
        Ticket ticketById = ticketService.getTicketById(id);
        if (ticketById != null) {
            return R.ok().data("ticket", ticketById);
        }
        return R.error().message("按id查找ticket无结果");
    }

    @GetMapping("/getTicketByShow/{showId}")
    public R getTicketByShow(@PathVariable Long showId) {
        List<Ticket> ticketByShow = ticketService.getTicketByShow(showId);
        if (ticketByShow != null && !ticketByShow.isEmpty()){
            return R.ok().data("ticket",ticketByShow);
        }
        return R.error().message("按show查找ticket无结果");
    }

    @GetMapping("/getAllTicket")
    public R getAllTicket(){
        List<Ticket> allTicket = ticketService.getAllTicket();
        if(allTicket!=null&&!allTicket.isEmpty()){
            return R.ok().data("ticket",allTicket);
        }
        return R.error().message("查找ticket无结果");
    }

    @DeleteMapping("/deleteTicket/{id}")
    public R deleteTicket(@PathVariable Long id){
        int i = ticketService.deleteTicket(id);
        if(i>0){
            return  R.ok().message("删除ticket成功");
        }
        return R.error().message("删除ticket失败");
    }
}