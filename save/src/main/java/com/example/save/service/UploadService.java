package com.example.save.service;

import com.example.save.bean.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface UploadService {
    Result upload(MultipartFile file, HttpServletRequest request) throws IOException;
}
