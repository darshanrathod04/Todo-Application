package com.application.todoList.controller;

import com.application.todoList.entity.Task;

import com.application.todoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task addtask(@RequestBody Task task){

        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getTask(){
        return service.getAllTask();
    }

    @DeleteMapping
    public Task deleteTask(@RequestParam Long id){

        return service.deleteBYId(id);
    }

}
