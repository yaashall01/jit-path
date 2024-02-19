package com.jobintech.jitpath.controller;


import com.jobintech.jitpath.model.Step;
import com.jobintech.jitpath.service.StepService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/step")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping("/all")
    public List<Step> getAllSteps(){
        return stepService.getAllSteps();
    }

    @GetMapping("/details/{stepId}")
    public Step getStep(@PathVariable Long stepId){
        return stepService.getStepById(stepId);
    }

    @PostMapping("/add")
    public void addStep(@RequestBody Step step){
        stepService.createStep(step);
    }

    @PutMapping("/update/{stepId}")
    public void updateStep(@PathVariable Long stepId, @RequestBody Step step){
        stepService.updateStepById(stepId, step);
    }

    @DeleteMapping("/delete/{stepId}")
    public void deleteStep(@PathVariable Long stepId){
        stepService.deleteStepById(stepId);
    }
}
