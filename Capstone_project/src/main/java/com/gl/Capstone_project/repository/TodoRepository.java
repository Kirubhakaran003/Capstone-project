package com.gl.Capstone_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.Capstone_project.Entity.TodoList;

public interface TodoRepository extends JpaRepository<TodoList,Long>{

}
