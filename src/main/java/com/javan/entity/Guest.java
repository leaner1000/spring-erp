package com.javan.entity;

public class Guest {
    private Integer guest_id;

    private String guest_name;

    private Integer consume_amount;

    private String phone_num;

    private String address;

    public Integer getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(Integer guest_id) {
        this.guest_id = guest_id;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name == null ? null : guest_name.trim();
    }

    public Integer getConsume_amount() {
        return consume_amount;
    }

    public void setConsume_amount(Integer consume_amount) {
        this.consume_amount = consume_amount;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num == null ? null : phone_num.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}