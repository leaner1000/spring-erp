package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Warehouse;

public interface WarehouseService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Warehouse getByid(int id);

    public String insert(Warehouse ob);

    public String updata(Warehouse ob);

    public String delete_batch(Integer[] ids);
}
