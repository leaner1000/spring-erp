package com.javan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OutBound {
    private Integer outbound_id;

    private Integer furniture_id;

    private Integer amount;

    private String warehouse_id;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy" ,timezone = "GMT+8")
    private Date date;

    public Integer getOutbound_id() {
        return outbound_id;
    }

    public void setOutbound_id(Integer outbound_id) {
        this.outbound_id = outbound_id;
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

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id == null ? null : warehouse_id.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}