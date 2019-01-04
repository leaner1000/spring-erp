package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.RepairMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.RepairExample;
import com.javan.entity.Repair;
import com.javan.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairImpl implements RepairService {
    @Autowired
    RepairMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        RepairExample example = new RepairExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Repair> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Repair> pageInfo = new PageInfo<Repair>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Repair getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Repair o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Repair o){
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
