package com.gqb.stock.entity.vo;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname TicketLockVo
 * @Description
 * @date 2021/4/15 21:01
 */
public class TicketLockVo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ticketId
     */
    private Long id;
    /**
     * 要进行锁库存的订单id
     */
    private Long orderId;
    /**
     * 要锁的数量
     */
    private int number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TicketLockVo() {
    }

    public TicketLockVo(Long id, Long orderId, int number) {
        this.id = id;
        this.orderId = orderId;
        this.number = number;
    }
}
