package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Provider;
import com.javan.entity.Status;
import com.javan.service.ProviderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProviderController {
    @Autowired
    private ProviderService ob;
    @RequestMapping(value = "/provider/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/provider/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Provider getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/provider/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"provider:add"})
    public Status insert(Provider o){
        Status s=new Status();
        if(ob.getByid(o.getProvider_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/provider/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"provider:update"})
    public Status update(Provider o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/provider/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"provider:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/provider/add",method = RequestMethod.GET)
    public String add(){
        return "provider_add";
    }

    @RequestMapping(value="/provider",method = RequestMethod.GET)
    public String furniture(){
        return "provider";
    }

    @RequestMapping(value="/provider/edit",method = RequestMethod.GET)
    public String edit(){
        return "provider_edit";
    }
}
