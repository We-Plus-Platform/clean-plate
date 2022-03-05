package com.example.save.serviceImpl;

import com.example.save.bean.Manage;
import com.example.save.bean.Result;
import com.example.save.bean.User;
import com.example.save.dao.LoginDao;
import com.example.save.dao.ManageDao;
import com.example.save.dao.UploadDao;
import com.example.save.service.UploadService;

import com.example.save.tool.Decode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadDao uploadDao;
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private ManageDao manageDao;


/**
 * @Author Young
 * @Description 上传图片，成功返回true，失败返回false。
 *              依据时间上传到不同文件夹。
 * @param file
 * @return boolean
 */
    @Override
    public Result upload(MultipartFile file, HttpServletRequest request) throws IOException {

        Result result = new Result();
        //获取当前上传图片的时间段
        Date date = new Date();
        String h = new SimpleDateFormat("HH").format(date);
        String d = new SimpleDateFormat("dd").format(date);
        int hour = Integer.parseInt(h), today = Integer.parseInt(d);

        System.out.println("upload:hour is " + hour);

        //依据时间段将图片存入不同文件夹
        String UPLOADED_FOLDER = "";
        String UPLOADED_FOLDER_mysql = "";
        int time = 0;
        if(hour >= 10 && hour <= 13) {
            UPLOADED_FOLDER = "C://Users//Administrator//Desktop//save//src//main//resources//static//host//noon//";
            UPLOADED_FOLDER_mysql = "/noon/";
            time = 1;
        } else if(hour >= 16 && hour <= 19) {
            UPLOADED_FOLDER = "C://Users//Administrator//Desktop//save//src//main//resources//static//host//evening//";
            UPLOADED_FOLDER_mysql = "/evening/";
            time = 2;
        } else {
            result.setStatus(10005);
            result.setInfor("非上传时段");
            return result;
        }
        System.out.println("upload:file name is " + file.getOriginalFilename());


//        String token = "2019212444";
        String token = "";
        User user = new User();

        Cookie[] cookies =  request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ojqksebs")) {
                    token = Decode.decode(cookie.getValue());
                    break;
                }
            }
        }

        Manage manage = manageDao.findByToken(token);

//判断文件是否为空
        if (file.isEmpty()){
            result.setStatus(10001);
            result.setInfor("error");//文件为空
            return result;
        }

        if (uploadDao.getOnceLimit(token) == 0){
            result.setStatus(10002);
            result.setInfor("上传次数已达到今天的限制");
            return result;
        }


        user = loginDao.findByToken(token);
        System.out.println("upload operator:" + user.getName() + user.getSchoolNum());


        String fileName = file.getOriginalFilename();

        String addressOne = "/noon/" + file.getOriginalFilename();
        String addressTwo = "/evening/" + file.getOriginalFilename();
        String find1 = uploadDao.getSameAddress(addressOne);
        String find2 = uploadDao.getSameAddress(addressTwo);

        if(find1 != null || find2 != null) {
            ArrayList<Character> aaa = new ArrayList<Character>();
            char[] list = file.getOriginalFilename().toCharArray();
            int index = 0;
            for (int i = 0; i < list.length; i++) {
                if (list[i] == '.') {
                    index = i;
                    break;
                }
            }
            for (int i = index; i < list.length; i++) {
                aaa.add(list[i]);
            }
            aaa.toArray();
            String last = String.valueOf(aaa);
            last = last.replace(",", "");
            last = last.replace("[", "");
            last = last.replace("]", "");
            last = last.replace(" ", "");
            System.out.println(last);

            fileName = user.getSchoolNum() + "_" + d + "_" + time + last;
        }
//            String addressChangeName = user.getSchoolNum() + "_" + d + "_" + time + last;
//            uploadDao.insertFake(find1,user.getSchoolNum(),
//                    addressOne, addressChangeName);
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + addressChangeName);
//            Files.write(path, bytes);
//
//            int changeLimit = (manage.getEverydayLimit() - 1);
//            System.out.println(changeLimit);
//            uploadDao.alterEverydayLimit(changeLimit, token);
//            uploadDao.alterOnceLimit(0, token);
//            result.setStatus(10000);
//            result.setInfor("success");
//            return result;
//        }
//        if(find2 != null) {
//            ArrayList<Character> aaa = new ArrayList<Character>();
//            char[] list = file.getOriginalFilename().toCharArray();
//            int index = 0;
//            for (int i = 0; i < list.length; i++) {
//                if (list[i] == '.') {
//                    index = i;
//                    break;
//                }
//            }
//            for (int i = index; i < list.length; i++) {
//                aaa.add(list[i]);
//            }
//            aaa.toArray();
//            String last = String.valueOf(aaa);
//            last = last.replace(",", "");
//            last = last.replace("[", "");
//            last = last.replace("]", "");
//            last = last.replace(" ", "");
//            System.out.println(last);
//
//            String addressChangeName = user.getSchoolNum() + "_" + time + last;
//            uploadDao.insertFake(find2,user.getSchoolNum(),
//                    addressTwo, addressChangeName);
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER + addressChangeName);
//            Files.write(path, bytes);
//
//            int changeLimit = (manage.getEverydayLimit() - 1);
//            System.out.println(changeLimit);
//            uploadDao.alterEverydayLimit(changeLimit, token);
//            uploadDao.alterOnceLimit(0, token);
//            result.setStatus(10000);
//            result.setInfor("success");
//            return result;
//        }


// 把图片存入文件夹
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + fileName);
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
            result.setStatus(10001);
            result.setInfor("error");
            return result;
        }

//把图片路径放入数据库
        try {
            uploadDao.insertAddress(user.getSchoolNum(), user.getName(),
                    UPLOADED_FOLDER_mysql + fileName, token, time);

            uploadDao.insertAddress_two(user.getSchoolNum(), user.getName(),
                    UPLOADED_FOLDER_mysql + fileName, token, time, d);

            int changeLimit = (manage.getEverydayLimit() - 1);
            System.out.println(changeLimit);
            uploadDao.alterEverydayLimit(changeLimit, token);
//            manageDao.alterDate(today, token);

        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(10001);
            result.setInfor("error");
            return result;
        }


        uploadDao.alterOnceLimit(0, token);

//业务结束
        result.setStatus(10000);
        result.setInfor("success");
        return result;
    }
}

