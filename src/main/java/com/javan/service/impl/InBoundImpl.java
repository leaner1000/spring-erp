package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.InBoundMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.InBoundExample;
import com.javan.entity.InBound;
import com.javan.service.InBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InBoundImpl implements InBoundService {
    @Autowired
    InBoundMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        InBoundExample example = new InBoundExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<InBound> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<InBound> pageInfo = new PageInfo<InBound>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public InBound getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(InBound o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(InBound o){
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
