package com.example.save.controller;

import com.example.save.bean.MyInfoResult;
import com.example.save.service.DataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class DataController {

    @Resource
    DataService dataService;
    @RequestMapping(value = "/host/myinfor",method = RequestMethod.GET)
    public MyInfoResult myInfo(HttpServletRequest request){
        return dataService.myInfo(request);
    }
}
