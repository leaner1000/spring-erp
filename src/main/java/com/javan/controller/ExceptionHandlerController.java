package com.javan.controller;

import com.javan.entity.Status;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerController{
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public Status unauthorizedExceptionHandler(Exception e){
        Status s=new Status();
        s.setstatus(400);
        s.setMsg("没有权限");
        return s;
    }
}
