package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Warehouse;
import com.javan.entity.Status;
import com.javan.service.WarehouseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WarehouseController {
    @Autowired
    private WarehouseService ob;
    @RequestMapping(value = "/warehouse/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/warehouse/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Warehouse getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/warehouse/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"warehouse:add"})
    public Status insert(Warehouse o){
        Status s=new Status();
        if(ob.getByid(o.getWarehouse_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/warehouse/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"warehouse:update"})
    public Status update(Warehouse o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/warehouse/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"warehouse:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/warehouse/add",method = RequestMethod.GET)
    public String add(){
        return "warehouse_add";
    }

    @RequestMapping(value="/warehouse",method = RequestMethod.GET)
    public String furniture(){
        return "warehouse";
    }

    @RequestMapping(value="/warehouse/edit",method = RequestMethod.GET)
    public String edit(){
        return "warehouse_edit";
    }
}
