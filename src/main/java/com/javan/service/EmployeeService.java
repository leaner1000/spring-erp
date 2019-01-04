package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Employee;

public interface EmployeeService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Employee getByid(int id);

    public String insert(Employee ob);

    public String updata(Employee ob);

    public String delete_batch(Integer[] ids);
}
