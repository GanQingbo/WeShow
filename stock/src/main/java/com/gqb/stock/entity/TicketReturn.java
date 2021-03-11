package com.gqb.stock.entity;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname TicketReturn
 * @Description 退座二次出售座位实体类
 * @date 2021/3/11 9:45
 */
public class TicketReturn implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long ticketId;

    private int seatNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public TicketReturn() {
    }

    public TicketReturn(Long id, Long ticketId, int seatNo) {
        this.id = id;
        this.ticketId = ticketId;
        this.seatNo = seatNo;
    }
}
