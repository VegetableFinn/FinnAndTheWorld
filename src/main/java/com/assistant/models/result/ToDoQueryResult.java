package com.assistant.models.result;

import java.util.List;

import com.assistant.models.todo.ToDoModel;

/**
 * @author hefan.hf
 * @version $Id: ToDoQueryResult, v 0.1 16/4/24 22:35 hefan.hf Exp $
 */
public class ToDoQueryResult extends BaseServiceResult {

    private List<ToDoModel> toDoModelList;

    public ToDoQueryResult() {
        super();
    }

    /**
     * Getter method for property <tt>toDoModelList</tt>.
     *
     * @return property value of toDoModelList
     */

    public List<ToDoModel> getToDoModelList() {
        return toDoModelList;
    }

    /**
     * Setter method for property <tt>toDoModelList</tt>.
     *
     * @param toDoModelList value to be assigned to property toDoModelList
     */
    public void setToDoModelList(List<ToDoModel> toDoModelList) {
        this.toDoModelList = toDoModelList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ToDoQueryResult{");
        sb.append("toDoModelList=").append(toDoModelList);
        sb.append('}');
        return sb.toString();
    }
}