package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Guest;
import com.javan.entity.Status;
import com.javan.service.GuestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestController {
    @Autowired
    private GuestService ob;
    @RequestMapping(value = "/guest/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/guest/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Guest getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/guest/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"guest:add"})
    public Status insert(Guest o){
        Status s=new Status();
        if(ob.getByid(o.getGuest_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/guest/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"guest:update"})
    public Status update(Guest o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/guest/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"guest:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/guest/add",method = RequestMethod.GET)
    public String add(){
        return "guest_add";
    }

    @RequestMapping(value="/guest",method = RequestMethod.GET)
    public String furniture(){
        return "guest";
    }

    @RequestMapping(value="/guest/edit",method = RequestMethod.GET)
    public String edit(){
        return "guest_edit";
    }
}
