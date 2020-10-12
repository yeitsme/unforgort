package cn.itcast.dao;

import cn.itcast.entity.Person;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {
   @Select("select * from person where id=#{id}")
    Person selectOne(Integer id);
}
