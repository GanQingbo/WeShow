package com.gqb.user.entity.vo;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname IdentityCheckVo
 * @Description
 * @date 2021/4/23 20:51
 */
public class IdentityCheckVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ticketId;
    private String[] number;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String[] getNumber() {
        return number;
    }

    public void setNumber(String[] number) {
        this.number = number;
    }

    public IdentityCheckVo() {
    }

    public IdentityCheckVo(Long ticketId, String[] number) {
        this.ticketId = ticketId;
        this.number = number;
    }
}
