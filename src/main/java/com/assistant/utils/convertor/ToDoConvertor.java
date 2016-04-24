package com.assistant.utils.convertor;

import java.util.ArrayList;
import java.util.List;

import com.assistant.db.model.ToDo;
import com.assistant.models.todo.ToDoModel;
import com.assistant.utils.DateUtil;

/**
 * @author hefan.hf
 * @version $Id: ToDoConvertor, v 0.1 16/4/24 22:28 hefan.hf Exp $
 */
public class ToDoConvertor {

	/**
	 * 转换成Model
	 *
	 * @param toDo
	 * @return
	 */
	public static ToDoModel convertToModel(ToDo toDo) {
		ToDoModel toDoModel = new ToDoModel();
		toDoModel.setContent(toDo.getContent());
		toDoModel.setCatagory(toDo.getCatagory());
		toDoModel.setId(toDo.getId());
		toDoModel.setIsDone(toDo.getIsDone());
		toDoModel.setDt(DateUtil.convertToDoString(toDo.getDt()));

		return toDoModel;
	}

	/**
	 * 列表转换
	 *
	 * @param toDos
	 * @return
	 */
	public static List<ToDoModel> convertToModelList(List<ToDo> toDos) {
		List<ToDoModel> toDoModels = new ArrayList<ToDoModel>();
		for (ToDo toDo : toDos) {
			toDoModels.add(convertToModel(toDo));
		}
		return toDoModels;
	}

}