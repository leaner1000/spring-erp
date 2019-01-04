package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Employee;
import com.javan.entity.Status;
import com.javan.service.EmployeeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService ob;
    @RequestMapping(value = "/employee/page",method = RequestMethod.POST)
    @ResponseBody
    public EUDataGridResult OutboundList(Integer page,Integer rows){
        return ob.getPage(page,rows);
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Employee getOB(@PathVariable Integer id){
        return ob.getByid(id);
    }

    @RequestMapping(value="/employee/insert",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"employee:add"})
    public Status insert(Employee o){
        Status s=new Status();
        if(ob.getByid(o.getEmployee_id())!=null){
            s.setstatus(400);
            s.setMsg("编号重复");
            return s;
        }
        System.out.print(o);
        ob.insert(o);
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/employee/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"employee:update"})
    public Status update(Employee o){
        ob.updata(o);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }
    @RequestMapping(value="/employee/delete_batch",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions({"employee:delete"})
    public Status delete(Integer[] ids){
        ob.delete_batch(ids);
        Status s=new Status();
        s.setstatus(200);
        return s;
    }

    @RequestMapping(value="/employee/add",method = RequestMethod.GET)
    public String add(){
        return "employee_add";
    }

    @RequestMapping(value="/employee",method = RequestMethod.GET)
    public String furniture(){
        return "employee";
    }

    @RequestMapping(value="/employee/edit",method = RequestMethod.GET)
    public String edit(){
        return "employee_edit";
    }
}
