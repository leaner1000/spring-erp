
package com.javan.service;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Purchase;

public interface PurchaseService {
    public EUDataGridResult getPage(int page_num, int pagesize);

    public Purchase getByid(int id);

    public String insert(Purchase ob);

    public String updata(Purchase ob);

    public String delete_batch(Integer[] ids);
}
