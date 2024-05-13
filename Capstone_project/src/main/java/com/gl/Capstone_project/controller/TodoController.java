package com.gl.Capstone_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.Capstone_project.Dto.TodoDto;
import com.gl.Capstone_project.service.TodoService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/todolist")
public class TodoController {
		@Autowired
		private TodoService todoService;

		// Build Create or Add Department REST API
		@PostMapping
		public ResponseEntity<TodoDto> createTodoList(@RequestBody TodoDto todoDto) {
			TodoDto todoList = todoService.createTodoList(todoDto);
			return new ResponseEntity<>(todoList, HttpStatus.CREATED);
		}

		// Build Get Department REST API
		@GetMapping("{id}") // /api/departments/id
		public ResponseEntity<TodoDto> getDepartmentById(@PathVariable("id") Long todoListId) {
			TodoDto todoDto = todoService.getTodoListById(todoListId);
			return ResponseEntity.ok(todoDto);
		}

		// Build Get All Departments REST API
		@GetMapping // /api/departments
		public ResponseEntity<List<TodoDto>> getAllTodoList() {
			List<TodoDto> todoLists = todoService.getAllTodoList();
			return ResponseEntity.ok(todoLists);
		}

		// Build Update Departments REST API
		@PutMapping("{id}") // /api/departments/id
		public ResponseEntity<TodoDto> updateTodoList(@PathVariable("id") Long todoListId,
				@RequestBody TodoDto updatedTodoList) {

			TodoDto departmentDto = todoService.updateTodoList(todoListId, updatedTodoList);
			return ResponseEntity.ok(departmentDto);
		}
		
		@PutMapping("/updatestatus/{id}")
		public  ResponseEntity<TodoDto>updateTodoCompleted(@PathVariable("id") Long todoListId,@RequestBody TodoDto updatedTodoList ){
			TodoDto todoDto=todoService.updateTodoCompleted(todoListId, updatedTodoList);
			return ResponseEntity.ok(todoDto);

		}

		// Build Delete Departments REST API
		@DeleteMapping("{id}") // /api/departments/id
		public ResponseEntity<String> deleteTodoList(@PathVariable("id") Long todoListId) {
			todoService.deleteTodoList(todoListId);
			return ResponseEntity.ok("Department deleted successfully!.");
		}
}
