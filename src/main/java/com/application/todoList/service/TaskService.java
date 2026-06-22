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

    public List<Task> getAllTask(){
        return taskRepo.findAll();
    }

    public Task deleteBYId(Long id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepo.deleteById(id);
        return task;
    }



}

