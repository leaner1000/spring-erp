package com.javan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Purchase {
    private Integer purchase_id;

    private String guest_id;

    private String furniture_name;

    private Integer furniture_id;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy" ,timezone = "GMT+8")
    private Date purchase_date;

    private String amount;

    private BigDecimal total_price;

    private String receive_money;

    private String remarks;

    public Integer getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Integer purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(String guest_id) {
        this.guest_id = guest_id == null ? null : guest_id.trim();
    }

    public String getFurniture_name() {
        return furniture_name;
    }

    public void setFurniture_name(String furniture_name) {
        this.furniture_name = furniture_name == null ? null : furniture_name.trim();
    }

    public Integer getFurniture_id() {
        return furniture_id;
    }

    public void setFurniture_id(Integer furniture_id) {
        this.furniture_id = furniture_id;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getReceive_money() {
        return receive_money;
    }

    public void setReceive_money(String receive_money) {
        this.receive_money = receive_money == null ? null : receive_money.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}