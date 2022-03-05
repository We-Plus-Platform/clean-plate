package com.example.save.dao;

import com.example.save.bean.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DataDao {
    @Select("select * from b_property where token=#{token}")
    Property myInfo(String token);

    @Select("select lastRice from b_manage where token=#{token}")
    int myLastRice(String token);

    @Select("select onceLimit from b_manage where token=#{token}")
    int myOnceLimit(String token);


    @Select("select schoolNum from b_property where token=#{token}")
    String mySchoolNum(String token);
}
