package com.assistant.db.dao;

import java.util.List;

import com.assistant.db.model.One;

public interface OneMapper {
    int deleteByPrimaryKey(String title);

    int insert(One record);

    int insertSelective(One record);

    One selectByPrimaryKey(String title);

    int updateByPrimaryKeySelective(One record);

    int updateByPrimaryKeyWithBLOBs(One record);

    int updateByPrimaryKey(One record);

    List<One> selectAll();
}