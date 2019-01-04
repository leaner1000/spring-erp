package com.javan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class InBound {
    private Integer inbound_id;

    private Integer furniture_id;

    private Integer amount;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy" ,timezone = "GMT+8")
    private Date date;

    private Integer warehouse_id;

    public Integer getInbound_id() {
        return inbound_id;
    }

    public void setInbound_id(Integer inbound_id) {
        this.inbound_id = inbound_id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }
}