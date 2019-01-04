package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.GuestMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.GuestExample;
import com.javan.entity.Guest;
import com.javan.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuestImpl implements GuestService {
    @Autowired
    GuestMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        GuestExample example = new GuestExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Guest> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Guest> pageInfo = new PageInfo<Guest>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Guest getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Guest o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Guest o){
        ob.updateByPrimaryKeySelective(o);
        return "";
    }

    @Override
    public String delete_batch(Integer [] ids){
        for(int i:ids){
            ob.deleteByPrimaryKey(i);
        }
        return "";
    }
}
