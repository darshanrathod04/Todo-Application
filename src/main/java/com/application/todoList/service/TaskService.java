package com.application.todoList.service;

import com.application.todoList.entity.Task;
import com.application.todoList.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public Task createTask(Task task){
        return taskRepo.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepo.findAll();
    }

    public Task upadateTask(Long id, Task taskDetails){
        Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setCompleted(taskDetails.getCompleted());
        return taskRepo.save(task);
    }

    public void deleteTask(Long id){
        Task task = taskRepo.findById(id).orElseThrow();
        taskRepo.delete(task);
    }



}

