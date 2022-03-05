package com.example.save.controller;

import com.example.save.bean.PicsAddressResult;
import com.example.save.service.PicsAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Z_PicsAddressController {
    @Resource
    PicsAddressService picsAddressService;

    @RequestMapping(value = "/host/pics_address",method = GET)
    PicsAddressResult picsAddress(){
        return picsAddressService.picsAddress();
    }
}
