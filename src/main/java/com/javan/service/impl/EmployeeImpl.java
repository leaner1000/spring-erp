package com.javan.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javan.dao.EmployeeMapper;
import com.javan.entity.EUDataGridResult;
import com.javan.entity.EmployeeExample;
import com.javan.entity.Employee;
import com.javan.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    EmployeeMapper ob;
    @Override
    public EUDataGridResult getPage(int pageNum, int pageSize){
        //查询客户列表
        EmployeeExample example = new EmployeeExample();
        //分页处理
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list = ob.selectByExample(example);
        //创建一个返回值对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        //取记录总条数
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public Employee getByid(int id){
        return ob.selectByPrimaryKey(id);
    }


    @Override
    public String insert(Employee o){
        ob.insertSelective(o);
        return "";
    }
    @Override
    public String updata(Employee o){
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
