package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.WarehouseMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.WarehouseExample;
import com.javan.entity.Warehouse;
import com.javan.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WarehouseImpl implements WarehouseService {
    @Autowired
    WarehouseMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        WarehouseExample example = new WarehouseExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Warehouse> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Warehouse> pageInfo = new PageInfo<Warehouse>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Warehouse getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Warehouse o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Warehouse o){
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
