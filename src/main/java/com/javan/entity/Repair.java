package com.javan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Repair {
    private Integer repair_id;

    private Integer furniture_id;

    private String damage_condition;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @JsonFormat(pattern = "MM/dd/yyyy" ,timezone = "GMT+8")
    private Date send_date;

    private Integer employee_id;

    private Integer guest_id;

    private String repair_state;

    private String amount;

    public Integer getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(Integer repair_id) {
        this.repair_id = repair_id;
    }

    public Integer getFurniture_id() {
        return furniture_id;
    }

    public void setFurniture_id(Integer furniture_id) {
        this.furniture_id = furniture_id;
    }

    public String getDamage_condition() {
        return damage_condition;
    }

    public void setDamage_condition(String damage_condition) {
        this.damage_condition = damage_condition == null ? null : damage_condition.trim();
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public String getRepair_state() {
        return repair_state;
    }

    public void setRepair_state(String repair_state) {
        this.repair_state = repair_state == null ? null : repair_state.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }
}