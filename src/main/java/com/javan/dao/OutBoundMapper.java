package com.javan.dao;

import com.javan.entity.OutBound;
import com.javan.entity.OutBoundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutBoundMapper {
    int countByExample(OutBoundExample example);

    int deleteByExample(OutBoundExample example);

    int deleteByPrimaryKey(Integer outbound_id);

    int insert(OutBound record);

    int insertSelective(OutBound record);

    List<OutBound> selectByExample(OutBoundExample example);

    OutBound selectByPrimaryKey(Integer outbound_id);

    int updateByExampleSelective(@Param("record") OutBound record, @Param("example") OutBoundExample example);

    int updateByExample(@Param("record") OutBound record, @Param("example") OutBoundExample example);

    int updateByPrimaryKeySelective(OutBound record);

    int updateByPrimaryKey(OutBound record);
}