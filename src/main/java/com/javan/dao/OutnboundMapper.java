package com.javan.dao;

import com.javan.entity.Outnbound;

public interface OutnboundMapper {
    int deleteByPrimaryKey(Integer outbount_id);

    int insert(Outnbound record);

    int insertSelective(Outnbound record);

    Outnbound selectByPrimaryKey(Integer outbount_id);

    int updateByPrimaryKeySelective(Outnbound record);

    int updateByPrimaryKey(Outnbound record);
}