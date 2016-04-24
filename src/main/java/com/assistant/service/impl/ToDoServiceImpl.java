package com.assistant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.ToDoMapper;
import com.assistant.db.model.ToDo;
import com.assistant.models.result.ToDoQueryResult;
import com.assistant.service.ToDoService;
import com.assistant.utils.convertor.ToDoConvertor;

/**
 * @author hefan.hf
 * @version $Id: ToDoServiceImpl, v 0.1 16/4/24 22:26 hefan.hf Exp $
 */
@Service("toDoService")
public class ToDoServiceImpl extends BaseService implements ToDoService {

    @Autowired
    private ToDoMapper toDoMapper;

    @Override
    public ToDoQueryResult selectWeek() {
        ToDoQueryResult result = new ToDoQueryResult();
        List<ToDo> toDos = toDoMapper.selectWeek();
        result.setToDoModelList(ToDoConvertor.convertToModelList(toDos));
        return result;
    }
}