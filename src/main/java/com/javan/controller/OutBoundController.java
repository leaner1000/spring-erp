package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.OutBound;
import com.javan.entity.Status;
import com.javan.service.OutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OutBoundController {
    @Autowired
   private OutBoundService ob;
    @RequestMapping(value = "/outbound/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/outbound/{id}",method = RequestMethod.GET)
    @ResponseBody
    public OutBound getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/outbound/insert",method = RequestMethod.POST)
    @ResponseBody
    public Status insert(OutBound o){
        System.out.print(o);
        ob.insert(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/outbound/update",method = RequestMethod.POST)
    @ResponseBody
    public Status update(OutBound o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/outbound/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/outbound/add",method = RequestMethod.GET)
    public String add(){
        return "outbound_add";
    }

    @RequestMapping(value="/outbound",method = RequestMethod.GET)
    public String furniture(){
        return "outbound";
    }

    @RequestMapping(value="/outbound/edit",method = RequestMethod.GET)
    public String edit(){
        return "outbound_edit";
    }


}
