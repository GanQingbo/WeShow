package com.gqb.user.entity;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname TicketSell
 * @Description
 * @date 2021/4/23 21:03
 */
public class TicketSell implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long showId;
    private String identityNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public TicketSell() {
    }

    public TicketSell(Long id, Long showId, String identityNumber) {
        this.id = id;
        this.showId = showId;
        this.identityNumber = identityNumber;
    }
}
