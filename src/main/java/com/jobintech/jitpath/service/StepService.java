package com.jobintech.jitpath.service;

import com.jobintech.jitpath.model.Step;
import com.jobintech.jitpath.repository.StepRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StepService {

    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<Step> getAllSteps() {
        return stepRepository.findAll();
    }

    public Step getStepById(Long stepId) {
        return stepRepository.findById(stepId).orElse(null);
    }

    public void createStep(Step step) {
        stepRepository.save(step);
        log.info("Step added: {}", step.getTitle());
    }

    public void updateStepById(Long stepId, Step step) {
        Step stepUpdate = stepRepository.findById(stepId).orElse(null);
        if (stepUpdate != null) {
            stepUpdate.setTitle(step.getTitle());
            stepUpdate.setDescription(step.getDescription());
            stepUpdate.setType(step.getType());
            stepUpdate.setTasks(step.getTasks());
            stepRepository.save(stepUpdate);
            log.info("Step updated: {}", step.getTitle());
        } else {
            log.error("Step with id : {} not found", stepId);
        }
    }

    public void deleteStepById(Long stepId) {
        stepRepository.deleteById(stepId);
        log.info("Step deleted: {}", stepId);
    }
}
