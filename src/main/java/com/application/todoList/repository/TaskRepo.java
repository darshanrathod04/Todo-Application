package com.application.todoList.repository;

import com.application.todoList.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
