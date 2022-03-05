package com.example.save.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestCookies {

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String setCookies(HttpServletResponse response){

        String token = "2019214625";
        Cookie cookie = new Cookie("token",token);
        cookie.setMaxAge(60*60*10);
        response.addCookie(cookie);

        return "add successfully";
    }


    //非注解方式获取cookie中对应的key值
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request){

        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println(cookie);
                if(cookie.getName().equals("sessionId")){
                    return cookie.getValue();
                }
            }
        }
        return  "null";
    }



    //注解方式获取cookie中对应的key值
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("sessionId") String sessionId ) {
        System.out.println("testCookieValue,sessionId="+sessionId);
        return "SUCCESS";
    }

}

