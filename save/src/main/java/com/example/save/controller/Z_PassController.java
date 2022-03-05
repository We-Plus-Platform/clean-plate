package com.example.save.controller;

import com.example.save.bean.Z_PassBean;
import com.example.save.service.Z_PassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class Z_PassController {
    @Resource
    Z_PassService z_passService;

    @PostMapping(path = "/host/pass")
    void pass(@RequestBody Z_PassBean z_passBean){
        z_passService.pass(z_passBean.getSchoolNum(), z_passBean.getTime(), z_passBean.getResult());
    }
}
