package com.example.save.controller;

import com.example.save.bean.FileBean;
import com.example.save.bean.LoginBean;
import com.example.save.bean.Result;
import com.example.save.service.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UploadController {

    @Resource
    private UploadService uploadService;

    @RequestMapping(value = "/host/upload", method = POST)
    public Result uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        return uploadService.upload(file, request);
    }

//    @PostMapping(path="/upload")
//    public Result uploadFile(FileBean fileBean, HttpServletRequest request){
//        System.out.println(fileBean.getFile().getOriginalFilename());
//        return uploadService.upload(fileBean.getFile(), request);
//    }


}
