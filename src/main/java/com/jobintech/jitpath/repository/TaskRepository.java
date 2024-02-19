package com.jobintech.jitpath.repository;

import com.jobintech.jitpath.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
