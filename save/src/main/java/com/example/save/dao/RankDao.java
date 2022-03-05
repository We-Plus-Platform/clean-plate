package com.example.save.dao;

import com.example.save.bean.Property;
import com.example.save.bean.TopList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RankDao {
    @Select("select * from b_property")
    TopList[] getRank();

    @Select("select * from b_property")
    Property[] getRank2();
}
