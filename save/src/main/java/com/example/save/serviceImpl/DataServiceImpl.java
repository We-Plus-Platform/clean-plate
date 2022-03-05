package com.example.save.serviceImpl;

import com.example.save.bean.MyInfoResult;
import com.example.save.bean.Property;
import com.example.save.bean.TopList;
import com.example.save.dao.DataDao;
import com.example.save.dao.RankDao;
import com.example.save.service.DataService;
import com.example.save.tool.Decode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    DataDao dataDao;

    @Autowired
    RankDao rankDao;

    @Override
    public MyInfoResult myInfo(HttpServletRequest request) {

        MyInfoResult myInfoResult = new MyInfoResult();
        Property property = new Property();
        int lastRice = 0, myRank = 0, count = 0, onceLimit = 0;
        String token = "";
//        String token = "2019212444";

        Cookie[] cookies =  request.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ojqksebs")) {
                    token = Decode.decode(cookie.getValue());
                    break;
                }
            }
        }

//        property = dataDao.myInfo("2019212444");


        property = dataDao.myInfo(token);

        try {
            System.out.println("data operator:" + property.getName() + property.getSchoolNum());
            lastRice = dataDao.myLastRice(token);
            onceLimit = dataDao.myOnceLimit(token);
        } catch (Exception e) {
            System.out.println("data:null user");
        }

        Property[] properties =  rankDao.getRank2();

        if(properties.length >= 2 ) {
            for (int i = 0; i < properties.length - 1; i++) {
                for (int j = 0; j < properties.length - i - 1; j++) {
                    if (properties[j].getRice() < properties[j + 1].getRice()) {
                        Property temp = properties[j];
                        properties[j] = properties[j + 1];
                        properties[j + 1] = temp;
                    }
                }
            }
        }

        String schoolNum = dataDao.mySchoolNum(token);
        for (Property p : properties ) {
            count++;
            if(p.getSchoolNum().equals(schoolNum)){
                myRank = count;
                break;
            }
        }


        Date date = new Date();
        String h = new SimpleDateFormat("HH").format(date);
        int hour = Integer.parseInt(h);

        if(!(hour >= 10 && hour <= 13) && !(hour >= 16 && hour <= 19)) {
            onceLimit = 0;
        }

        if(property != null){
            myInfoResult.setStatus(10000);
            myInfoResult.setInfor("success");
            property.setLastRice(lastRice);
            property.setMyRank(myRank);
            property.setOnceLimit(onceLimit);

////正式上线之后进行注释
//property.setOnceLimit(0);
/////////
            myInfoResult.setProperty(property);
            return myInfoResult;
        }
        myInfoResult.setStatus(10001);
        myInfoResult.setInfor("error");
        return myInfoResult;
    }
}

//{
//​    // 个人
//      path: '/myinfor',
//      method: 'get',
//{
//    data: {
//        status: 10000,
//        infor: 'success',
//        data: {
//            name: string,
//            count: number
//        },
//    }
//},
//
//{
//    "result": {
//        "status": 10000,
//        "infor": "success"
//    },
//    "myself": {
//        "name": "yhf",
//        "yesterdayCount": 0,
//        "count": 0
//    }
//}
//
//{
//"result": {
//"status": 10000,
//"infor": "success",
//"loginSuccess": {
//"school_num": 2019212444,
//"yesterday": 0,
//"everydayLimited": 0,
//"rice": 0
//}
//},
//"loginSuccess": null
//}