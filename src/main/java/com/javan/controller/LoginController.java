package com.javan.controller;

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
    public Map<String,Object> Login(@RequestParam String username,@RequestParam String password,@RequestParam(required=false) String validate_code,HttpSession session){
        Map<String,Object> map = new HashMap();
        Subject currentUser = SecurityUtils.getSubject();
        if(!validate_code.equals(session.getAttribute("validate_code"))){
            map.put("msg","验证码错误");
            return map;
        }
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try{
                currentUser.login(token);
            }catch(UnknownAccountException ex){
                map.put("msg", "account_error");
            }catch(IncorrectCredentialsException ex){
                map.put("msg", "password_error");
            }catch(AuthenticationException ex){
                map.put("msg", "authentication_error");
            }
        }
        return map;
    }
    @RequestMapping(value="/validate",method=RequestMethod.GET)
    public String validate(){
        return "validate";
    }


    @RequestMapping(value="/",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
}
