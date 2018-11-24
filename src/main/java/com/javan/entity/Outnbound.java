package com.javan.entity;

import java.util.Date;

public class Outnbound {
    private Integer outbount_id;

    private Integer furniture_id;

    private Integer amount;

    private String position;

    private Date date;

    public Integer getOutbount_id() {
        return outbount_id;
    }

    public void setOutbount_id(Integer outbount_id) {
        this.outbount_id = outbount_id;
    }

    public Integer getFurniture_id() {
        return furniture_id;
    }

    public void setFurniture_id(Integer furniture_id) {
        this.furniture_id = furniture_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}