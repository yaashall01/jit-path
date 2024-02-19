package com.jobintech.jitpath.service;

import com.jobintech.jitpath.model.Task;
import com.jobintech.jitpath.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        log.info("Fetching all tasks");
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Task getTaskById(Long taskId) {
        log.info("Fetching task with id: {}", taskId);
        return taskRepository.findById(taskId).orElse(null);
    }

    @Transactional
    public void createTask(Task task) {
        log.info("Creating task: {}", task);
        taskRepository.save(task);
    }

    @Transactional
    public void updateTask(Long taskId, Task task) {
        log.info("Updating task with id: {}", taskId);
        Task taskUpdate = taskRepository.findById(taskId).orElse(null);
        if (taskUpdate != null) {
            taskUpdate.setTitle(task.getTitle());
            taskUpdate.setDescription(task.getDescription());
            taskUpdate.setStatus(task.getStatus());
            taskUpdate.setDateOfSubmission(task.getDateOfSubmission());
            taskRepository.save(taskUpdate);
        }else {
            log.info("Task with id: {} not found", taskId);
        }
    }

    @Transactional
    public void deleteTask(Long taskId) {
        log.info("Deleting task with id: {}", taskId);
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void deleteAllTasks() {
        log.info("Deleting all tasks");
        taskRepository.deleteAll();
    }
}
