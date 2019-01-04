package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.InBound;
import com.javan.entity.Status;
import com.javan.service.InBoundService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InBoundController {
    @Autowired
    private InBoundService ob;
    @RequestMapping(value = "/inbound/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/inbound/{id}",method = RequestMethod.GET)
    @ResponseBody
    public InBound getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/inbound/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"inbound:add"})
    public Status insert(InBound o){
        Status s=new Status();
        if(ob.getByid(o.getInbound_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/inbound/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"inbound:update"})
    public Status update(InBound o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/inbound/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"inbound:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/inbound/add",method = RequestMethod.GET)
    public String add(){
        return "inbound_add";
    }

    @RequestMapping(value="/inbound",method = RequestMethod.GET)
    public String furniture(){
        return "inbound";
    }

    @RequestMapping(value="/inbound/edit",method = RequestMethod.GET)
    public String edit(){
        return "inbound_edit";
    }
}
