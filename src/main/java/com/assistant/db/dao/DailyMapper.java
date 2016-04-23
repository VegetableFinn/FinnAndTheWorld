package com.assistant.db.dao;

import java.util.List;

import com.assistant.db.model.Daily;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Daily record);

    int insertSelective(Daily record);

    Daily selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Daily record);

    int updateByPrimaryKey(Daily record);

    List<Daily> selectRecent2DaysDesc();

}