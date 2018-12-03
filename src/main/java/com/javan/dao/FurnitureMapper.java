package com.javan.dao;

import com.javan.entity.Furniture;
import com.javan.entity.FurnitureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FurnitureMapper {
    int countByExample(FurnitureExample example);

    int deleteByExample(FurnitureExample example);

    int deleteByPrimaryKey(Integer furniture_id);

    int insert(Furniture record);

    int insertSelective(Furniture record);

    List<Furniture> selectByExample(FurnitureExample example);

    Furniture selectByPrimaryKey(Integer furniture_id);

    int updateByExampleSelective(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByExample(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByPrimaryKeySelective(Furniture record);

    int updateByPrimaryKey(Furniture record);
}