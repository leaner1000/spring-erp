package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Provider;

public interface ProviderService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Provider getByid(int id);

    public String insert(Provider ob);

    public String updata(Provider ob);

    public String delete_batch(Integer[] ids);
}
