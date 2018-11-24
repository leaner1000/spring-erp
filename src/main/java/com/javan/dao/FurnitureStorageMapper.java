package com.javan.dao;

import com.javan.entity.FurnitureStorage;

public interface FurnitureStorageMapper {
    int deleteByPrimaryKey(Integer furniture_id);

    int insert(FurnitureStorage record);

    int insertSelective(FurnitureStorage record);

    FurnitureStorage selectByPrimaryKey(Integer furniture_id);

    int updateByPrimaryKeySelective(FurnitureStorage record);

    int updateByPrimaryKey(FurnitureStorage record);
}