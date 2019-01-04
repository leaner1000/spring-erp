package com.javan.controller;

import com.javan.entity.EUDataGridResult;
import com.javan.entity.Furniture;
import com.javan.entity.Status;
import com.javan.service.FurnitureService;
import com.sun.deploy.net.HttpResponse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;


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
        @RequiresPermissions({"furniture:add"})
        public Status insert(@RequestPart("picture_path") Part picture, @Validated Furniture f, BindingResult bindingResult, HttpServletRequest request){
                Status s=new Status();
                String upload_path=request.getSession().getServletContext().getRealPath("")+"WEB-INF\\img\\"+picture.getSubmittedFileName();  //图片上传路径
                f.setPicture_path("/img/"+picture.getSubmittedFileName());
                try {
                        picture.write(upload_path);
                } catch (IOException e) {
                        s.setstatus(400);
                        s.setMsg("上传失败");
                        return s;
                }
                if(bindingResult.hasErrors()){
                        FieldError fieldError = bindingResult.getFieldError();
                        s.setMsg(fieldError.getDefaultMessage());
                        s.setstatus(400);
                        return s;
                }
                if(fs.getByid(f.getFurniture_id())!=null){
                        s.setstatus(400);
                        s.setMsg("编号重复");
                        return s;
                }
                fs.insert(f);
                s.setstatus(200);
                return s;
        }

        @RequestMapping(value="/furniture/update",method = RequestMethod.POST)
        @ResponseBody
        @RequiresPermissions({"furniture:update"})
        public Status update(@Validated Furniture f, BindingResult bindingResult){
                Status s=new Status();
                if(bindingResult.hasErrors()){
                        FieldError fieldError = bindingResult.getFieldError();
                        s.setMsg(fieldError.getDefaultMessage());
                        s.setstatus(400);
                        return s;
                }
                fs.updata(f);
                s.setstatus(200);
                return s;
        }
        @RequestMapping(value="/furniture/delete_batch",method = RequestMethod.POST)
        @ResponseBody
        @RequiresPermissions({"furniture:delete"})
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

        @RequestMapping(value="/furniture/edit",method = RequestMethod.GET)
        public String edit(){
                return "furniture_edit";
        }


}
