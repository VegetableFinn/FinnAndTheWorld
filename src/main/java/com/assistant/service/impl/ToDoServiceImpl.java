package com.assistant.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistant.db.dao.ToDoMapper;
import com.assistant.db.model.ToDo;
import com.assistant.models.enums.TrueFalseEnum;
import com.assistant.models.result.BaseServiceResult;
import com.assistant.models.result.ToDoQueryResult;
import com.assistant.service.ToDoService;
import com.assistant.utils.DateUtil;
import com.assistant.utils.StringUtil;
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

	@Override
	public BaseServiceResult editTodo(int id, String newStatus) {
		BaseServiceResult result = new BaseServiceResult();
		ToDo toDo = toDoMapper.selectByPrimaryKey(id);
		Date now = commonService.getSysDate();
		toDo.setGmtModified(now);
		toDo.setIsDone(newStatus);
		if (StringUtil.equals("T", newStatus)) {
			toDo.setFinishDt(now);
		}
		toDoMapper.updateByPrimaryKey(toDo);
		return result;
	}

	@Override
	public BaseServiceResult addTodo(String content, String catagory, String dt) {
		BaseServiceResult result = new BaseServiceResult();

		Date now = commonService.getSysDate();
		ToDo toDo = new ToDo();
		toDo.setIsDone(TrueFalseEnum.FALSE.getCode());
		toDo.setCatagory(catagory);
		toDo.setGmtCreate(now);
		toDo.setGmtModified(now);
		toDo.setContent(content);

		try {
			toDo.setDt(DateUtil.convertFromTodoString(dt));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		toDoMapper.insert(toDo);

		return result;
	}

	@Override
	public BaseServiceResult deleteTodo(int id) {
		BaseServiceResult result = new BaseServiceResult();
		toDoMapper.deleteByPrimaryKey(id);
		return result;
	}
}