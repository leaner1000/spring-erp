package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.OutstockMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.OutstockExample;
import com.javan.entity.Outstock;
import com.javan.service.OutstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OutstockImpl implements OutstockService {
    @Autowired
    OutstockMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        OutstockExample example = new OutstockExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Outstock> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Outstock> pageInfo = new PageInfo<Outstock>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Outstock getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Outstock o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Outstock o){
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
