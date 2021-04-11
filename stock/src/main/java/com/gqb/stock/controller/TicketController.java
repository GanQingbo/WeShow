package com.gqb.stock.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.entity.vo.TicketQuery;
import com.gqb.stock.service.TicketService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname TicketController
 * @Description
 * @date 2021/3/10 10:23
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Resource
    private TicketService ticketService;

    /**
     * 售票列表
     */
    @PostMapping("/getTicketByPage/{page}/{size}")
    public R getTicketByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody TicketQuery ticketQuery){
        PageInfo<TicketQuery> userByPage = ticketService.getTicketByPage(page, size, ticketQuery);
        if(userByPage!=null){
            return R.ok().data("ticket",userByPage);
        }
        return R.error().message("无查询结果");
    }

    /**
    *@Description 新建Ticket
    *@param ticket
    *@return
    */
    @PostMapping("/createTicket")
    public R createTicket(@RequestBody Ticket ticket) {
        int i = ticketService.createTicket(ticket);
        if (i > 0) {
            return R.ok().data("id", ticket.getId());
        }
        return R.error().message("创建售票信息失败");
    }

    @GetMapping("/getTicketById/{id}")
    public R getTicketById(@PathVariable(value = "id") Long id) {
        Ticket ticketById = ticketService.getTicketById(id);
        if (ticketById != null) {
            return R.ok().data("ticket", ticketById);
        }
        return R.error().message("按id查找ticket无结果");
    }

    @GetMapping("/getTicketQueryById/{id}")
    public R getTicketQueryById(@PathVariable(value = "id") Long id) {
        TicketQuery queryById = ticketService.getTicketQueryById(id);
        if (queryById != null) {
            return R.ok().data("ticket", queryById);
        }
        return R.error().message("按id查找ticket无结果");
    }

    @GetMapping("/getTicketByShow/{showId}")
    public R getTicketByShow(@PathVariable(value = "showId") Long showId) {
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
    public R deleteTicket(@PathVariable(value = "id") Long id){
        int i = ticketService.deleteTicket(id);
        if(i>0){
            return  R.ok().message("删除ticket成功");
        }
        return R.error().message("删除ticket失败");
    }

    @PostMapping("/updateTicket")
    public R updateTicket(@RequestBody Ticket ticket){
        int i = ticketService.updateTicket(ticket);
        if(i>0){
            return  R.ok().message("更新ticket信息成功");
        }
        return R.error().message("更新ticket信息失败");
    }

    @PostMapping("/sellTicket/{id}")
    public R sellTicket(@PathVariable(value = "id") Long id){
        int i = ticketService.sellTicket(id);
        if(i>0){
            //返回剩余票数
            return R.ok().message("售票成功").data("seat_no",i);
        }
        return R.error().message("售票失败");
    }

    @GetMapping("/getPriceById/{id}")
    public BigDecimal getPriceById(@PathVariable(value = "id") Long id){
        BigDecimal price = ticketService.getPrice(id);
        return price;
    }

    @GetMapping("/getSurplusById/{id}")
    public Integer getSurplusById(@PathVariable(value = "id") Long id){
        int surplus = ticketService.getSurplus(id);
        return surplus;
    }
}
