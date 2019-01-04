package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Outstock;

public interface OutstockService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Outstock getByid(int id);

    public String insert(Outstock ob);

    public String updata(Outstock ob);

    public String delete_batch(Integer[] ids);
}
