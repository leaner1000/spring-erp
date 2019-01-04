package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Guest;

public interface GuestService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Guest getByid(int id);

    public String insert(Guest ob);

    public String updata(Guest ob);

    public String delete_batch(Integer[] ids);
}
