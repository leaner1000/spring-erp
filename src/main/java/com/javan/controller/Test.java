package com.javan.controller;

import com.javan.dao.FurnitureMapper;
import com.javan.entity.Furniture;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.ArrayList;


@Controller
public class Test {
        @Resource
        FurnitureMapper fm;
        @RequestMapping(value = "/furniture",method = RequestMethod.POST)
        @ResponseBody
        public int insertFurniture(Furniture person){
            return fm.insertSelective(person);
        }
        @RequestMapping(value = "/furniture/{id}",method = RequestMethod.GET)
        @ResponseBody
        public Furniture getFurniture(@PathVariable Integer id){
            return fm.selectByPrimaryKey(id);
        }
        @RequestMapping(value = "/furniture/page/{num}",method = RequestMethod.GET)
        @ResponseBody
        public ArrayList<Furniture> getFurnitures(@PathVariable Integer num) {
                ArrayList<Furniture> af = new ArrayList<Furniture>();
                for (int i = 0; i < num * 10; i++) {
                        af.add(fm.selectByPrimaryKey(i));
                }
                return af;
        }
}
