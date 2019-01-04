package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Purchase;
import com.javan.entity.Status;
import com.javan.service.PurchaseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PurchaseController {
    @Autowired
    private PurchaseService ob;
    @RequestMapping(value = "/purchase/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/purchase/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Purchase getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/purchase/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"purchase:add"})
    public Status insert(Purchase o){
        Status s=new Status();
        if(ob.getByid(o.getPurchase_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/purchase/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"purchase:update"})
    public Status update(Purchase o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/purchase/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"purchase:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/purchase/add",method = RequestMethod.GET)
    public String add(){
        return "purchase_add";
    }

    @RequestMapping(value="/purchase",method = RequestMethod.GET)
    public String furniture(){
        return "purchase";
    }

    @RequestMapping(value="/purchase/edit",method = RequestMethod.GET)
    public String edit(){
        return "purchase_edit";
    }
}
