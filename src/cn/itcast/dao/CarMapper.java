package cn.itcast.dao;

import cn.itcast.entity.Card;
import cn.itcast.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 证件和人的关系
 */
public interface CarMapper {
    @Select("select * from card")
    @Results({
            //映射当前查询表的数据
        @Result(column = "id",property = "id"),
        @Result(column = "number",property = "number"),
            //映射另一个查询表
            @Result(
                    property = "person",//被包含的对象名
                    javaType = Person.class,//被包含的实际数据类型
                    column = "pid",//根据从表查询的数据pid来查询主表
                    one = @One(select = "cn.itcast.dao.PersonMapper.selectOne")
            )
    })
    public List<Card> selectAll();
}
