package cn.itcast.dao;


import cn.itcast.entity.Card;
import cn.itcast.entity.Person;
import cn.itcast.service.OneToOne;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test01 {
    @Test
    public void selectCard() {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //mybatis缓存问题,一级缓存由sqlSession执行的sql叫做一级缓存,sqlSessionFactory创建的多个sqlSession执行的sql就是二级缓存
            sqlSession = factory.openSession(true);
            CarMapper mapper = sqlSession.getMapper(CarMapper.class);
            List<Card> cards = mapper.selectAll();
            for (Card card : cards) {
                System.out.println(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void selectOne() {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("MyBatisConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //mybatis缓存问题,一级缓存由sqlSession执行的sql叫做一级缓存,sqlSessionFactory创建的多个sqlSession执行的sql就是二级缓存
            sqlSession = factory.openSession(true);
            OneToOne mapper = sqlSession.getMapper(OneToOne.class);
            List<Person> cards = mapper.findOne(1);
            for (Person card : cards) {
                System.out.println(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
