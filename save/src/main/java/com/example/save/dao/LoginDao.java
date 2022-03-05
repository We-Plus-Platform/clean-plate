package com.example.save.dao;

import com.example.save.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {

//注册时查看有无此学号
    @Select("select * from a_register where schoolNum=#{schoolNum}")
    User findBySchoolNum(String schoolNum);
//注册，插入学号、姓名、密码
    @Insert("insert into a_register(schoolNum,name,password) values(#{schoolNum},#{name},#{password})")
    void register(String schoolNum, String name, String password);

//登陆时对比学号与密码
    @Select("select * from a_register where schoolNum=#{schoolNum} and password=#{password}")
    User login(String schoolNum, String password);

//通过token获取用户
    @Select("select * from a_user where token=#{token}")
    User findByToken(String token);

//写入用户表
    @Insert("insert into a_user(schoolNum,name,token) values(#{schoolNum},#{name},#{token})")
    void writeIntoUser(String schoolNum, String name, String token);
//写入资产表
    @Insert("insert into b_property(schoolNum,name,token,rice) values(#{schoolNum},#{name},#{token},#{rice})")
    void writeIntoProperty(String schoolNum, String name, String token, int rice);
//写入管理表
    @Insert("insert into b_manage(schoolNum,name,lastRice,everydayLimit,token,date,onceLimit) " +
            "values(#{schoolNum},#{name},#{lastRice},#{everydayLimit},#{token},#{date},#{onceLimit})")
    void writeIntoManage(String schoolNum, String name, int lastRice, int everydayLimit, String token, int date, int onceLimit);

}
