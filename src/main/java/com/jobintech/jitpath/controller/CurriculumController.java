package com.jobintech.jitpath.controller;


import com.jobintech.jitpath.dto.CurriculumDto;
import com.jobintech.jitpath.service.CurriculumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curriculum")
public class CurriculumController {

    private final CurriculumService curriculumService;

    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    @GetMapping("/details/{curriculumId}")
    public CurriculumDto getCurriculum(@PathVariable Long curriculumId) {
        return curriculumService.getDetailsByIdCurriculum(curriculumId);
    }

    @GetMapping("/all")
    public List<CurriculumDto> getAllCurriculum() {
        return curriculumService.getAllCurriculums();
    }

    @PostMapping("/create")
    public CurriculumDto createCurriculum(@RequestBody CurriculumDto curriculumDto) {
        return curriculumService.createCurriculum(curriculumDto);
    }

    @PutMapping("/update/{curriculumId}")
    public CurriculumDto updateCurriculum(@PathVariable Long curriculumId, @RequestBody CurriculumDto curriculumDto) {
        return curriculumService.updateCurriculum(curriculumId, curriculumDto);
    }

    @DeleteMapping("/delete/{curriculumId}")
    public void deleteCurriculum(@PathVariable Long curriculumId) {
        curriculumService.deleteCurriculumById(curriculumId);
    }
}
