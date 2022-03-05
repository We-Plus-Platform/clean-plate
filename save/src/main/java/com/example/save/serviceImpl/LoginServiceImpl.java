package com.example.save.serviceImpl;

import com.example.save.bean.Result;
import com.example.save.bean.User;
import com.example.save.dao.LoginDao;
import com.example.save.service.LoginService;
import com.example.save.tool.Code;
import com.example.save.tool.Decode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    @Override
    public Result register(String schoolNum, String name, String password,
                           HttpServletResponse response, HttpServletRequest request) {
        Result result = new Result();

////正式上线后将其注释
//result.setStatus(20001);
//result.setInfor("用户已存在");
//return result;
/////////

        User user = loginDao.findBySchoolNum(schoolNum);
        if(user != null){
            result.setStatus(20001);
            result.setInfor("用户已存在");
            return result;
        }
        System.out.println("register:" + name + schoolNum);
        try {
            loginDao.register(schoolNum, name, password);
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(10001);
            result.setInfor("error");//有未知异常，数据库过载、服务器出现问题等
            return result;
        }


        String token = "";
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("ojqksebs")) {
                    token = Decode.decode(cookie.getValue());
                    User checkUserToken = loginDao.findByToken(token);

                    if(checkUserToken.getSchoolNum().equals(schoolNum)){
                        System.out.println("register:local token.schoolNum is " + checkUserToken.getSchoolNum());
                        System.out.println("register:inputted schoolNum is " + schoolNum);

                        result.setStatus(20000);
                        result.setInfor("匹配成功");//登陆成功。已登录过，并和原本token匹配成功
                        return result;
                    }
                    break;
                }
            }
        }

        token = Code.code(schoolNum);
        Cookie cookie = new Cookie("ojqksebs",token);
        cookie.setMaxAge(60 * 60 * 24 * 22);
        response.addCookie(cookie);

        token = Decode.decode(token);
//        int rice = 0, yesterdayProperty = 0, everydayLimit = 2;
        Date date_ = new Date();
        String d = new SimpleDateFormat("dd").format(date_);
        int date = Integer.parseInt(d);

        loginDao.writeIntoUser(schoolNum, name, token);
        loginDao.writeIntoProperty(schoolNum, name, token, 0);
        loginDao.writeIntoManage(schoolNum, name, 0, 2, token, date, 1);
        result.setStatus(10000);
        result.setInfor("success");//登陆成功，首次登陆
        return result;

    }

    @Override
    public Result login(String schoolNum, String password, HttpServletResponse response, HttpServletRequest request) {
        Result result = new Result();
        User user = loginDao.login(schoolNum, password);

        System.out.println("login:schoolNum and password " + schoolNum + "," + password);
//        System.out.println(user.getName());
        if(user == null){
            result.setStatus(10001);
            result.setInfor("用户不存在");
            return result;
        }
        String token;

//        Cookie[] cookies =  request.getCookies();
//        if(cookies != null){
//            for(Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")) {
//                    token = cookie.getValue();
//                    User checkUserToken = loginDao.findByToken(token);
//
//                    if(checkUserToken.getSchoolNum().equals(schoolNum)){
//                        System.out.println("login:local token.schoolNum is " + checkUserToken.getSchoolNum());
//                        System.out.println("login:inputted schoolNum is " + schoolNum);
//
//                        result.setStatus(20000);
//                        result.setInfor("匹配成功");//登陆成功。已登录过，并和原本token匹配成功
//                        return result;
//                    }
//                    break;
//                }
//            }
//        }

        token = Code.code(schoolNum);
        Cookie cookie = new Cookie("ojqksebs",token);
        cookie.setMaxAge(12*60*60);
        response.addCookie(cookie);

////        int rice = 0, yesterdayProperty = 0, everydayLimit = 2;
//        loginDao.writeIntoUser(schoolNum, user.getName(), token);
//        loginDao.writeIntoProperty(schoolNum, user.getName(), token, 0);
//        loginDao.writeIntoManage(schoolNum, user.getName(), 0, 2, token, 1);
        result.setStatus(10000);
        result.setInfor("success");//登陆成功，首次登陆
        return result;
    }

    @Override
    public Result checkToken(HttpServletRequest request){
        Result result = new Result();
        User user = new User();

        Cookie[] cookies =  request.getCookies();
        System.out.println("log_check:cookies is " + cookies);
        if(cookies == null){
            result.setStatus(10002);
            result.setInfor("没有token");
            return result;
        }

        for(Cookie cookie : cookies) {
            if (cookie.getName().equals("ojqksebs")) {
                String token = Decode.decode(cookie.getValue());
                user = loginDao.findByToken(token);
                break;
            }
        }


        if(user == null){
            result.setStatus(10001);
            result.setInfor("error");
            return result;
        }//有token，但此token未匹配到用户

        System.out.println("log_check operator:" + user.getName() + user.getSchoolNum());

        result.setStatus(10000);
        result.setInfor("success");
        return result;
    }

}
