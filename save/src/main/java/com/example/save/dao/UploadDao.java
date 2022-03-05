package com.example.save.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UploadDao {

    @Insert("insert into c_address(schoolNum,name,address,token,time) " +
            "values(#{schoolNum},#{name},#{address},#{token},#{time})")
    void insertAddress(String schoolNum, String name, String address, String token, int time);
    @Insert("insert into d_address(schoolNum,name,address,token,time,date) " +
            "values(#{schoolNum},#{name},#{address},#{token},#{time},#{d})")
    void insertAddress_two(String schoolNum, String name, String address, String token, int time, String d);

    @Update("update b_manage set everydayLimit=#{everydayLimit} where token=#{token}")
    void alterEverydayLimit(int everydayLimit, String token);

    @Update("update b_manage set onceLimit=#{onceLimit} where token=#{token}")
    void alterOnceLimit(int onceLimit, String token);

    @Select("select onceLimit from b_manage where token=#{token}")
    int getOnceLimit(String token);

    @Select("select schoolNum from c_address where address=#{address} limit 1")
    String getSameAddress(String address);

    @Insert("insert into d_fake(schoolNumOne,schoolNumTwo,addressOne,addressTwo) " +
            "values(#{schoolNumOne},#{schoolNumTwo},#{addressOne},#{addressTwo})")
    void insertFake(String schoolNumOne, String schoolNumTwo, String addressOne, String addressTwo);

}
