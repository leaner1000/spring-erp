package com.javan.entity;

public class Furniture {
    private Integer furniture_id;

    private String furniture_name;

    private String furniture_discription;

    private String picture_path;

    private String provider;

    private String warehouse_id;

    private Integer amount;

    public Integer getFurniture_id() {
        return furniture_id;
    }

    public void setFurniture_id(Integer furniture_id) {
        this.furniture_id = furniture_id;
    }

    public String getFurniture_name() {
        return furniture_name;
    }

    public void setFurniture_name(String furniture_name) {
        this.furniture_name = furniture_name == null ? null : furniture_name.trim();
    }

    public String getFurniture_discription() {
        return furniture_discription;
    }

    public void setFurniture_discription(String furniture_discription) {
        this.furniture_discription = furniture_discription == null ? null : furniture_discription.trim();
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path == null ? null : picture_path.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id == null ? null : warehouse_id.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}