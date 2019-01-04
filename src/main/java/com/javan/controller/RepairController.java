package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Repair;
import com.javan.entity.Status;
import com.javan.service.RepairService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RepairController {
    @Autowired
    private RepairService ob;
    @RequestMapping(value = "/repair/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/repair/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Repair getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/repair/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"repair:add"})
    public Status insert(Repair o){
        Status s=new Status();
        if(ob.getByid(o.getRepair_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/repair/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"repair:update"})
    public Status update(Repair o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/repair/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"repair:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/repair/add",method = RequestMethod.GET)
    public String add(){
        return "repair_add";
    }

    @RequestMapping(value="/repair",method = RequestMethod.GET)
    public String furniture(){
        return "repair";
    }

    @RequestMapping(value="/repair/edit",method = RequestMethod.GET)
    public String edit(){
        return "repair_edit";
    }
}
