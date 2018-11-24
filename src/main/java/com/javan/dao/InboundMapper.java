package com.javan.dao;

import com.javan.entity.Inbound;

public interface InboundMapper {
    int deleteByPrimaryKey(Integer purchase_id);

    int insert(Inbound record);

    int insertSelective(Inbound record);

    Inbound selectByPrimaryKey(Integer purchase_id);

    int updateByPrimaryKeySelective(Inbound record);

    int updateByPrimaryKey(Inbound record);
}