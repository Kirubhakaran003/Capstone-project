package com.gl.Capstone_project.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.Capstone_project.Dto.TodoDto;
import com.gl.Capstone_project.Entity.TodoList;
import com.gl.Capstone_project.mapper.TodoMapper;
import com.gl.Capstone_project.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoService {


		@Autowired
		private TodoRepository todoRepository;
		
		public TodoDto createTodoList(TodoDto todoDto) {
			TodoList todoList = TodoMapper.mapToDepartment(todoDto);
			TodoList SavedTodoList = todoRepository.save(todoList);
			return TodoMapper.mapToTodoDto(SavedTodoList);
		}

		public TodoDto getTodoListById(Long todoListId) {
			Optional<TodoList> opt = todoRepository.findById(todoListId);
			if (opt.get() != null) {
				TodoList todoList = opt.get();
				return TodoMapper.mapToTodoDto(todoList);
			}
			return null;
		}

		public List<TodoDto> getAllTodoList() {
			List<TodoList> todoLists = todoRepository.findAll();
			return todoLists.stream().map((todoList) -> TodoMapper.mapToTodoDto(todoList))
					.collect(Collectors.toList());
		}

		public TodoDto
		updateTodoList(Long todoListId, TodoDto updatedTodoList) {
			Optional<TodoList> opt = todoRepository.findById(todoListId);

			TodoList todoList = null;
			if (opt.get() != null) {
				todoList = opt.get();
				todoList.setTitle(updatedTodoList.getTitle());
				todoList.setDescription(updatedTodoList.getDescription());
				todoList.setStatus(updatedTodoList.getStatus());

				TodoList SavedTodoList = todoRepository.save(todoList);

				return TodoMapper.mapToTodoDto(SavedTodoList);
			}
			return null;
		}

		public TodoDto updateTodoCompleted(Long todoListId,TodoDto updatedTodoList) {

			Optional<TodoList>opt=todoRepository.findById(todoListId);
			TodoList todoList=null;
			if(opt.get()!=null) {
				todoList=opt.get();
				todoList.setStatus(updatedTodoList.getStatus());
				TodoList savedTodoList=todoRepository.save(todoList);
				return TodoMapper.mapToTodoDto(savedTodoList);

			}
			return null;

		}

		
		
		public void deleteTodoList(Long todoListId) {
//			departmentRepository.findById(departmentId).orElseThrow(
//					() -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId));
			todoRepository.deleteById(todoListId);
		}
	

}
