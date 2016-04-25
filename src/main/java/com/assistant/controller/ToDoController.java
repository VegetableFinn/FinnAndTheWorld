package com.assistant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.ToDoQueryResult;
import com.assistant.service.ToDoService;

/**
 * @author hefan.hf
 * @version $Id: ToDoController, v 0.1 16/4/24 22:25 hefan.hf Exp $
 */
@Controller
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDOService;

    @RequestMapping("/getToDoList")
    public @ResponseBody ToDoQueryResult getRecentTwoDaysOrderByDt() {
        return toDOService.selectWeek();
    }

    @RequestMapping("/editTodo")
    public @ResponseBody BaseServiceResult editTodo(int id, String newStatus) {
        return toDOService.editTodo(id, newStatus);
    }

    @RequestMapping("/addTodo")
    public @ResponseBody BaseServiceResult addTodo(String content, String catagory, String dt) {
        return toDOService.addTodo(content, catagory, dt);
    }

    @RequestMapping("/deleteTodo")
    public @ResponseBody BaseServiceResult deleteTodo(int id) {
        return toDOService.deleteTodo(id);
    }

}