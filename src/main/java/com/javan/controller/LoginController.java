package com.javan.controller;

import com.javan.entity.Status;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Status Login(@RequestParam String username, @RequestParam String password, @RequestParam(required=false) String validate_code, HttpSession session){
        Status s = new Status();
        s.setstatus(200);
        Subject currentUser = SecurityUtils.getSubject();
        if(!validate_code.equals(session.getAttribute("validate_code"))){
            s.setMsg("验证码错误");
            s.setstatus(400);
            return s;
        }
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try{
                currentUser.login(token);
            }catch(UnknownAccountException ex){
                s.setMsg("用户不存在");
                s.setstatus(400);
            }catch(IncorrectCredentialsException ex){
                s.setMsg("密码错误");
                s.setstatus(400);
            }catch(AuthenticationException ex){
                s.setMsg("没有权限");
                s.setstatus(400);
            }
        }
        return s;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
    }

    @RequestMapping(value="/validate",method=RequestMethod.GET)
    public String validate(){
        return "validate";
    }

    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
}
