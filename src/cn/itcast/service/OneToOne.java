package cn.itcast.service;

import cn.itcast.entity.Card;
import cn.itcast.entity.Person;

import java.util.List;

public interface OneToOne {
    public List<Person> findOne(int id);
}
