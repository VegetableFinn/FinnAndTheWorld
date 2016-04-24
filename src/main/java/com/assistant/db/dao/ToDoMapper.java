package com.assistant.db.dao;

import java.util.List;

import com.assistant.db.model.ToDo;

public interface ToDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ToDo record);

    int insertSelective(ToDo record);

    ToDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ToDo record);

    int updateByPrimaryKey(ToDo record);

    List<ToDo> selectWeek();

}