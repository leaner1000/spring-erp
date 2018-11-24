package com.javan.dao;

import com.javan.entity.Furniture;

public interface FurnitureMapper {
    int deleteByPrimaryKey(Integer furniture_id);

    int insert(Furniture record);

    int insertSelective(Furniture record);

    Furniture selectByPrimaryKey(Integer furniture_id);

    int updateByPrimaryKeySelective(Furniture record);

    int updateByPrimaryKey(Furniture record);
}