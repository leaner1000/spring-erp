package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Outstock;
import com.javan.entity.Status;
import com.javan.service.OutstockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OutstockController {
    @Autowired
    private OutstockService ob;
    @RequestMapping(value = "/outstock/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/outstock/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Outstock getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/outstock/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"outstock:add"})
    public Status insert(Outstock o){
        Status s=new Status();
        if(ob.getByid(o.getId())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/outstock/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"outstock:update"})
    public Status update(Outstock o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/outstock/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"outstock:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/outstock/add",method = RequestMethod.GET)
    public String add(){
        return "outstock_add";
    }

    @RequestMapping(value="/outstock",method = RequestMethod.GET)
    public String furniture(){
        return "outstock";
    }

    @RequestMapping(value="/outstock/edit",method = RequestMethod.GET)
    public String edit(){
        return "outstock_edit";
    }
}
