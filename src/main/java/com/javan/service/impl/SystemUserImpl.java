package com.javan.service.impl;

import com.javan.dao.SystemUserMapper;
import com.javan.entity.SystemUser;
import com.javan.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemUserImpl implements SystemUserService {
    @Autowired
    SystemUserMapper sm;

    @Override
    public SystemUser getByName(String name){
        return sm.selectByPrimaryKey(name);
    }
}
