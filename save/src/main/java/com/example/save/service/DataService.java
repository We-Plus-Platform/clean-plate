package com.example.save.service;

import com.example.save.bean.MyInfoResult;

import javax.servlet.http.HttpServletRequest;

public interface DataService {
    MyInfoResult myInfo(HttpServletRequest request);
}
