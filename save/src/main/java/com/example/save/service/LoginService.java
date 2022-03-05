package com.example.save.service;

import com.example.save.bean.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    Result register(String schoolNum, String name, String password, HttpServletResponse response, HttpServletRequest request);
    Result login(String schoolNum, String password, HttpServletResponse response, HttpServletRequest request);
    Result checkToken(HttpServletRequest request);

}
