package com.javan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.FurnitureMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.Furniture;
import com.javan.entity.FurnitureExample;
import com.javan.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.FontUIResource;
import java.util.List;

@Service
public class FurnitureImpl implements FurnitureService {
    @Autowired
    FurnitureMapper fm;

    @Override
    public EUDataGridResult getPage(int pageNum,int pageSize){
        //查询客户列表
        FurnitureExample example = new FurnitureExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Furniture> list = fm.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Furniture> pageInfo = new PageInfo<Furniture>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Furniture getByid(int id){
        return fm.selectByPrimaryKey(id);
    }
    @Override
    public String insert(Furniture f){
        fm.insertSelective(f);
        return "";
    }
    @Override
    public String updata(Furniture f){
        fm.updateByPrimaryKeySelective(f);
        return "";
    }
    @Override
    public String delete_batch(Integer[] ids){
        for(int i:ids){
            fm.deleteByPrimaryKey(i);
        }
        return "";
    }
}
