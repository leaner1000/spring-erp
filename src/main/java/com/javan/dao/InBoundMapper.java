package com.javan.dao;

import com.javan.entity.InBound;
import com.javan.entity.InBoundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InBoundMapper {
    int countByExample(InBoundExample example);

    int deleteByExample(InBoundExample example);

    int deleteByPrimaryKey(Integer inbound_id);

    int insert(InBound record);

    int insertSelective(InBound record);

    List<InBound> selectByExample(InBoundExample example);

    InBound selectByPrimaryKey(Integer inbound_id);

    int updateByExampleSelective(@Param("record") InBound record, @Param("example") InBoundExample example);

    int updateByExample(@Param("record") InBound record, @Param("example") InBoundExample example);

    int updateByPrimaryKeySelective(InBound record);

    int updateByPrimaryKey(InBound record);
}