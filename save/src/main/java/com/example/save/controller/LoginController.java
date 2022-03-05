package com.example.save.controller;

import com.example.save.bean.LoginBean;
import com.example.save.bean.RegisterBean;
import com.example.save.bean.Result;
import com.example.save.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping(path="/host/log_up")
    public Result register(@RequestBody RegisterBean registerBean,
                           HttpServletResponse response, HttpServletRequest request){
        return loginService.register(registerBean.getSchoolNum(),
                registerBean.getName(), registerBean.getPassword(), response, request);
    }

    @PostMapping(path="/host/log_in")
    public Result login(@RequestBody LoginBean loginBean, HttpServletResponse response, HttpServletRequest request){
        return loginService.login(loginBean.getSchoolNum(), loginBean.getPassword(), response, request);
    }

    @RequestMapping(value = "/host/log_check", method = RequestMethod.GET)
    public Result checkToken(HttpServletRequest request){
        return loginService.checkToken(request);
    }
}
