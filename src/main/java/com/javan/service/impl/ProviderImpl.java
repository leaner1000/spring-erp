package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.ProviderMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.ProviderExample;
import com.javan.entity.Provider;
import com.javan.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProviderImpl implements ProviderService {
    @Autowired
    ProviderMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        ProviderExample example = new ProviderExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Provider> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Provider> pageInfo = new PageInfo<Provider>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Provider getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Provider o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Provider o){
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
