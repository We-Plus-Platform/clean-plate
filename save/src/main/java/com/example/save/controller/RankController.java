package com.example.save.controller;

import com.example.save.bean.TopListResult;
import com.example.save.service.RankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RankController {

    @Resource
    RankService rankService;

    @RequestMapping(value = "/host/toplist", method = GET)
    TopListResult getRank(){
        return rankService.getRank();
    }
}
