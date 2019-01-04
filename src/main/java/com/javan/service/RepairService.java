package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Repair;

public interface RepairService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Repair getByid(int id);

    public String insert(Repair ob);

    public String updata(Repair ob);

    public String delete_batch(Integer[] ids);
}
