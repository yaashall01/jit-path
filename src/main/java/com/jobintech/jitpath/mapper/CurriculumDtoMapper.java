package com.jobintech.jitpath.mapper;

import com.jobintech.jitpath.dto.CurriculumDto;
import com.jobintech.jitpath.model.Curriculum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Scope("singleton")
public class CurriculumDtoMapper implements EntityDtoMapper<Curriculum, CurriculumDto>{

    private final ExpertDtoMapper expertDtoMapper;

    public CurriculumDtoMapper(ExpertDtoMapper expertDtoMapper) {
        this.expertDtoMapper = expertDtoMapper;
    }


    @Override
    public CurriculumDto toDto(Curriculum curriculum) {
        return CurriculumDto.builder()
                .title(curriculum.getTitle())
                .description(curriculum.getDescription())
                .createdAt(curriculum.getCreatedAt())
                .durationInDays(curriculum.getDurationInDays())
                .curriculumStatus(curriculum.getStatus())
                .expert(expertDtoMapper.toDto(curriculum.getExpert()))
                .steps(curriculum.getSteps())
                .build();
    }

    @Override
    public Curriculum toEntity(CurriculumDto dto) {
        return Curriculum.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .createdAt(LocalDate.now())
                .durationInDays(dto.getDurationInDays())
                .status(dto.getCurriculumStatus())
                .expert(expertDtoMapper.toEntity(dto.getExpert()))
                .steps(dto.getSteps())
                .build();
    }
}
