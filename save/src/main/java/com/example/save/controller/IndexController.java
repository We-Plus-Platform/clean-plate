package com.example.save.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(path = "/dist")
    public String dist(){
        return "dist";
    }

}
