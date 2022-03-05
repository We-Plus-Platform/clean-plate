package com.example.save.dao;

import com.example.save.bean.PicsAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PicsAddressDao {

    @Select("select * from d_address")
    PicsAddress[] picsAddress();
}
