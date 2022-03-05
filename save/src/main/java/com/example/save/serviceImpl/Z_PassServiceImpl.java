package com.example.save.serviceImpl;

import com.example.save.bean.Manage;
import com.example.save.bean.Property;
import com.example.save.dao.ManageDao;
import com.example.save.dao.Z_PassDao;
import com.example.save.service.Z_PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class Z_PassServiceImpl implements Z_PassService {
    @Autowired
    Z_PassDao z_passDao;

    @Autowired
    ManageDao manageDao;

    @Override
    public void pass(String schoolNum, int time, int result) {

        Manage manage = manageDao.findBySchoolNum(schoolNum);
        if(manage.getEverydayLimit() != 2){
            z_passDao.alterEverydayLimit(schoolNum, 2);
        }

        if(result == 1){
            Date todayDate = new Date();
            String d = new SimpleDateFormat("dd").format(todayDate);
            int today = Integer.parseInt(d);

            int date = z_passDao.getDate(schoolNum);
            System.out.println(date);

            Property property = z_passDao.findBySchoolNum(schoolNum);
            int rice = (int)(Math.random() * 5 + 6);
            z_passDao.alterRice(schoolNum, time, rice + property.getRice());

            System.out.println(today + "," + date);
            if(today != date) {
                z_passDao.alterLastRice(schoolNum, rice);
                System.out.println("rice:" + rice);
                z_passDao.alterDate(schoolNum, today);
            } else {
                int lastRice = z_passDao.getLastRice(schoolNum);
                z_passDao.alterLastRice(schoolNum, rice + lastRice);
                System.out.println("........");
            }
        }

        z_passDao.deleteAddress(schoolNum, time);
    }
}

//    insert into c_address(schoolNum,time) values('',2)