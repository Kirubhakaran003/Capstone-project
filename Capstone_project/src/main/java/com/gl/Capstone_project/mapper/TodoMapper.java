package com.gl.Capstone_project.mapper;

import com.gl.Capstone_project.Dto.TodoDto;
import com.gl.Capstone_project.Entity.TodoList;

public class TodoMapper {

	//convert department jpa entity into department dto
		public static TodoDto mapToTodoDto (TodoList todoList) {
			return new TodoDto(
					todoList.getId(),
					todoList.getTitle(),
					todoList.getDescription(),
					todoList.getStatus()
					);
		}
		
		//convert department dto into department jpa entity
		public static TodoList mapToDepartment (TodoDto todoListDto) {
			return new TodoList(
					todoListDto.getId(),
					todoListDto.getTitle(),
					todoListDto.getDescription(),
					todoListDto.getStatus()
					);
		}
	}


