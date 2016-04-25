package com.assistant.service;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.ToDoQueryResult;

/**
 * @author hefan.hf
 * @version $Id: ToDoService, v 0.1 16/4/24 22:46 hefan.hf Exp $
 */
public interface ToDoService {

    ToDoQueryResult selectWeek();

    BaseServiceResult editTodo(int id, String newStatus);

    BaseServiceResult addTodo(String content, String catagory, String dt);

    BaseServiceResult deleteTodo(int id);
}