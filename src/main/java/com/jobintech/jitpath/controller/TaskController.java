package com.jobintech.jitpath.controller;

import com.jobintech.jitpath.model.Task;
import com.jobintech.jitpath.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/details/{taskId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Task getTaskById(@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }

    @DeleteMapping("/delete/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }

    @DeleteMapping("/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllTasks(){
        taskService.deleteAllTasks();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void createTask(@RequestBody Task task){
        taskService.createTask(task);
    }

    @PutMapping("/update/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@PathVariable Long taskId, @RequestBody Task task){
        taskService.updateTask(taskId, task);
    }
}
