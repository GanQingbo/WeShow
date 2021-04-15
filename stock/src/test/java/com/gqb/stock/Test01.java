package com.gqb.stock;

import com.gqb.stock.dao.TicketDao;
import com.gqb.stock.entity.Ticket;
import com.gqb.stock.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname Test01
 * @Description
 * @date 2021/4/14 23:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {
    @Resource
    TicketService ticketService;
    @Resource
    TicketDao ticketDao;

    @Test
    public void test(){
        Long id=2L;
        Ticket ticket = ticketDao.getTicketById(id);
        Date sellTime=ticket.getSellTime();
        Date date=new Date();
        System.out.println("开卖时间："+sellTime);
        System.out.println("当前时间："+new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = format.parse(sellTime);

        long d=sellTime.getTime()-date.getTime();
        System.out.println("差值："+d);
    }
}
