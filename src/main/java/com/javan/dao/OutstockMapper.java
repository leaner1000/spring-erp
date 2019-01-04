package com.javan.dao;

import com.javan.entity.Outstock;
import com.javan.entity.OutstockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutstockMapper {
    int countByExample(OutstockExample example);

    int deleteByExample(OutstockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Outstock record);

    int insertSelective(Outstock record);

    List<Outstock> selectByExample(OutstockExample example);

    Outstock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Outstock record, @Param("example") OutstockExample example);

    int updateByExample(@Param("record") Outstock record, @Param("example") OutstockExample example);

    int updateByPrimaryKeySelective(Outstock record);

    int updateByPrimaryKey(Outstock record);
}