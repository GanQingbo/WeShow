package com.gqb.order.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author GanQingbo
 * @Classname ConfirmVo
 * @Description 订单提交Vo
 * @date 2021/4/15 18:04
 */
public class ConfirmVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    private Long userId;

    private Long ticketId;
    /**
     * 购票数量
     */
    private int number;

    private BigDecimal amount;

    /**
     * 身份证号码
     */
    private String[] idNumber;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String[] getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String[] idNumber) {
        this.idNumber = idNumber;
    }

    public ConfirmVo() {
    }

    public ConfirmVo(String token, Long userId, Long ticketId, int number, BigDecimal amount, String[] idNumber) {
        this.token = token;
        this.userId = userId;
        this.ticketId = ticketId;
        this.number = number;
        this.amount = amount;
        this.idNumber = idNumber;
    }
}
