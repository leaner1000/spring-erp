package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Furniture;
import com.javan.entity.Status;
import com.javan.service.FurnitureService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller

public class FurnitureController {
        @Autowired
        private FurnitureService fs;

        @RequestMapping(value = "/furniture/page",method = RequestMethod.POST)
        @ResponseBody
        public EUDataGridResult FurnitureList(Integer page,Integer rows){
            return fs.getPage(page,rows);
        }

        @RequestMapping(value = "/furniture/{id}",method = RequestMethod.GET)
        @ResponseBody
        public Furniture getFurniture(@PathVariable Integer id){
            return fs.getByid(id);
        }

        @RequestMapping(value="/furniture/insert",method = RequestMethod.POST)
        @ResponseBody
        public Status insert(Furniture f){
                fs.insert(f);
                Status s=new Status();
                s.setstatus(200);
                return s;
        }

        @RequestMapping(value="/furniture/update",method = RequestMethod.POST)
        @ResponseBody
        public Status update(Furniture f){
                fs.updata(f);
                Status s=new Status();
                s.setstatus(200);
                return s;
        }
        @RequestMapping(value="/furniture/delete_batch",method = RequestMethod.POST)
        @ResponseBody
        public Status delete(Integer[] ids){
                fs.delete_batch(ids);
                Status s=new Status();
                s.setstatus(200);
                return s;
        }

        @RequestMapping(value="/furniture/add",method = RequestMethod.GET)
        public String add(){
                return "furniture_add";
        }

        @RequestMapping(value="/furniture",method = RequestMethod.GET)
        public String furniture(){
                return "furniture";
        }

        @RequestMapping(value="/home",method = RequestMethod.GET)
        public String home(){
                return "home";
        }
        @RequestMapping(value="/furniture/edit",method = RequestMethod.GET)
        public String edit(){
                return "furniture_edit";
        }


}
