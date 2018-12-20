package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.OutBoundMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.OutBoundExample;
import com.javan.entity.OutBound;
import com.javan.service.OutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutBoundImpl implements OutBoundService {
    @Autowired
    OutBoundMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        OutBoundExample example = new OutBoundExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<OutBound> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<OutBound> pageInfo = new PageInfo<OutBound>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public OutBound getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(OutBound o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(OutBound o){
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
