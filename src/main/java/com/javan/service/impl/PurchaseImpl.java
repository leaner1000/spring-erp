package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.PurchaseMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.PurchaseExample;
import com.javan.entity.Purchase;
import com.javan.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseImpl implements PurchaseService {
    @Autowired
    PurchaseMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        PurchaseExample example = new PurchaseExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Purchase> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Purchase> pageInfo = new PageInfo<Purchase>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Purchase getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Purchase o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Purchase o){
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