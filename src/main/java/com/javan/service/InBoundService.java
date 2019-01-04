package com.javan.service;

        import com.javan.entity.EUDataGridResult;
        import com.javan.entity.InBound;

public interface InBoundService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public InBound getByid(int id);

    public String insert(InBound ob);

    public String updata(InBound ob);

    public String delete_batch(Integer[] ids);
}
