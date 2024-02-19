package com.jobintech.jitpath.controller;

import com.jobintech.jitpath.dto.ExpertDto;
import com.jobintech.jitpath.dto.StudentDto;
import com.jobintech.jitpath.repository.ExpertRepository;
import com.jobintech.jitpath.service.ExpertService;
import com.jobintech.jitpath.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expert")
public class ExpertController {

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/details/{expertId}")
    public ExpertDto getExpertDetails(@PathVariable Long expertId) {
        return expertService.getExpertDetails(expertId);
    }

    @GetMapping("/all")
    public List<ExpertDto> getAllExperts(){
        return expertService.getAllExperts();
    }

    @PostMapping("/create")
    public ExpertDto createExpert(@RequestBody ExpertDto expertDto){
        return expertService.createExpert(expertDto);
    }

    @PutMapping("/update/{expertId}")
    public ExpertDto updateExpertById(@PathVariable Long expertId, @RequestBody ExpertDto expertDto){
        return expertService.updateExpert(expertId, expertDto);
    }

    @DeleteMapping("/delete/{expertId}")
    public void deleteExpertById(@PathVariable Long expertId){
        expertService.deleteExpertById(expertId);
    }


}
