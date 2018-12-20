package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.OutBound;

public interface OutBoundService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public OutBound getByid(int id);

    public String insert(OutBound ob);

    public String updata(OutBound ob);

    public String delete_batch(Integer[] ids);
}
