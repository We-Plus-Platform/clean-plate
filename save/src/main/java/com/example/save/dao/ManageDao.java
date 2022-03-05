package com.example.save.dao;

import com.example.save.bean.Manage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManageDao {
    @Select("select * from b_manage where token=#{token}")
    Manage findByToken(String token);

    @Select("select * from b_manage where schoolNum=#{schoolNum}")
    Manage findBySchoolNum(String schoolNum);

    @Update("update b_manage set date=#{date} where token=#{token}")
    void alterDate(int date, String token);
}
