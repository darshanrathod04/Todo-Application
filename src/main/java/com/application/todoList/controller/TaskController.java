package com.application.todoList.controller;

import com.application.todoList.entity.Task;
import com.application.todoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task addtask(@RequestBody Task task){
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return service.getAllTasks() ;
    }

    @PutMapping ("/{id}")
    public Task updateTask(@PathVariable Long id ,@RequestBody Task taskDetails){
        return service.upadateTask(id, taskDetails);
    }

    @DeleteMapping ("/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return "Deleted";
    }

}
