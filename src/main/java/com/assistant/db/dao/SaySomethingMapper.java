package com.assistant.db.dao;

import com.assistant.db.model.SaySomething;

public interface SaySomethingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SaySomething record);

    int insertSelective(SaySomething record);

    SaySomething selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SaySomething record);

    int updateByPrimaryKey(SaySomething record);

    SaySomething selectByTrigger(String triggerRegex);
}