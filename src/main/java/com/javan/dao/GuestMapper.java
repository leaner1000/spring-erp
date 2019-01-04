package com.javan.dao;

import com.javan.entity.Guest;
import com.javan.entity.GuestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuestMapper {
    int countByExample(GuestExample example);

    int deleteByExample(GuestExample example);

    int deleteByPrimaryKey(Integer guest_id);

    int insert(Guest record);

    int insertSelective(Guest record);

    List<Guest> selectByExample(GuestExample example);

    Guest selectByPrimaryKey(Integer guest_id);

    int updateByExampleSelective(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByExample(@Param("record") Guest record, @Param("example") GuestExample example);

    int updateByPrimaryKeySelective(Guest record);

    int updateByPrimaryKey(Guest record);
}