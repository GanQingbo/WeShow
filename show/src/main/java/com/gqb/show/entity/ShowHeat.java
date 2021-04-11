package com.gqb.show.entity;

import java.io.Serializable;

/**
 * @program: WeShow
 * @description: 演出热度
 * @author: Gan
 * @date: 2021-04-10 17:08
 **/
public class ShowHeat implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long showId;
    private int clicks;
    private int likes;
    private int comments;
    private int heat;

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

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public ShowHeat() {
    }

    public ShowHeat(Long id, Long showId, int clicks, int likes, int comments, int heat) {
        this.id = id;
        this.showId = showId;
        this.clicks = clicks;
        this.likes = likes;
        this.comments = comments;
        this.heat = heat;
    }

    @Override
    public String toString() {
        return "ShowHeat{" +
                "id=" + id +
                ", showId=" + showId +
                ", clicks=" + clicks +
                ", likes=" + likes +
                ", comments=" + comments +
                ", heat=" + heat +
                '}';
    }
}
