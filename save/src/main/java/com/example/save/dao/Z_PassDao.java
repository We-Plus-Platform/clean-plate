package com.example.save.dao;

import com.example.save.bean.Property;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Z_PassDao {
    @Update("update b_property set rice=#{rice} where schoolNum=#{schoolNum}")
    void alterRice(String schoolNum, int time, int rice);

    @Select("select * from b_property where schoolNum=#{schoolNum}")
    Property findBySchoolNum(String schoolNum);

    @Update("update b_manage set everydayLimit=#{everydayLimit} where schoolNum=#{schoolNum}")
    void alterEverydayLimit(String schoolNum, int everydayLimit);

    @Select("select date from b_manage where schoolNum=#{schoolNum}")
    int getDate(String schoolNum);

    @Update("update b_manage set date=#{date} where schoolNum=#{schoolNum}")
    void alterDate(String schoolNum, int date);

    @Update("update b_manage set lastRice=#{lastRice} where schoolNum=#{schoolNum}")
    void alterLastRice(String schoolNum, int lastRice);

    @Select("select lastRice from b_manage where schoolNum=#{schoolNum}")
    int getLastRice(String schoolNum);

    @Delete("delete from d_address where schoolNum=#{schoolNum} and time=#{time};")
    void deleteAddress(String schoolNum, int time);
}
