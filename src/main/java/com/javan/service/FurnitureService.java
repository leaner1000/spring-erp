package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Furniture;

public interface FurnitureService {
    public EUDataGridResult getPage(int page_num,int pagesize);

    public Furniture getByid(int id);

    public String insert(Furniture f);

    public String updata(Furniture f);

    public String delete_batch(Integer[] ids);
}
