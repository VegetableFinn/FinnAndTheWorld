package com.assistant.db.dao;

import java.util.List;

import com.assistant.db.model.OneApp;

public interface OneAppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OneApp record);

    int insertSelective(OneApp record);

    OneApp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OneApp record);

    int updateByPrimaryKeyWithBLOBs(OneApp record);

    int updateByPrimaryKey(OneApp record);

    List<OneApp> selectAll();

    OneApp selectLastOne();
}