package com.jobintech.jitpath.service;

import com.jobintech.jitpath.dto.CurriculumDto;
import com.jobintech.jitpath.exception.NotFoundException;
import com.jobintech.jitpath.mapper.CurriculumDtoMapper;
import com.jobintech.jitpath.mapper.EntityDtoMapper;
import com.jobintech.jitpath.model.Curriculum;
import com.jobintech.jitpath.repository.CurriculumRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;
    private final CurriculumDtoMapper curriculumDtoMapper;
    private final ExpertService expertService;

    public CurriculumService(CurriculumRepository curriculumRepository, CurriculumDtoMapper curriculumDtoMapper, ExpertService expertService) {
        this.curriculumRepository = curriculumRepository;
        this.curriculumDtoMapper = curriculumDtoMapper;
        this.expertService = expertService;
    }

    public CurriculumDto getDetailsByIdCurriculum(Long curriculumId) {
        log.info("Curriculum details for curriculum id: {}", curriculumId);
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new NotFoundException("Curriculum with id : "+ curriculumId +" not found"));
        return curriculumDtoMapper.toDto(curriculum);
    }

    public List<CurriculumDto> getAllCurriculums() {
        log.info("Fetching all curriculums");
        return curriculumDtoMapper.toDtos(curriculumRepository.findAll());
    }

    public CurriculumDto createCurriculum(CurriculumDto curriculumDto) {
        Curriculum newCurriculum = curriculumDtoMapper.toEntity(curriculumDto);
        Curriculum savedCurriculum = curriculumRepository.save(newCurriculum);
        log.info("Creating new curriculum name : " + curriculumDto.getTitle());
        return curriculumDtoMapper.toDto(savedCurriculum);
    }

    public CurriculumDto updateCurriculum(Long curriculumId, CurriculumDto curriculumDto) {
        Curriculum curriculumUpdate = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new NotFoundException("Curriculum with id : "+ curriculumId +" not found"));
        curriculumUpdate.setTitle(curriculumDto.getTitle());
        curriculumUpdate.setDescription(curriculumDto.getDescription());
        curriculumUpdate.setDurationInDays(curriculumDto.getDurationInDays());
        curriculumUpdate.setStatus(curriculumDto.getCurriculumStatus());
        curriculumUpdate.setSteps(curriculumDto.getSteps());
        //dir balek 3la expert update a traves Curriculum : updateExpertByCurriculumId
        curriculumRepository.save(curriculumUpdate);
        log.info("Updating curriculum name : " + curriculumDto.getTitle());
        return curriculumDtoMapper.toDto(curriculumUpdate);
    }

    public void deleteCurriculumById(Long curriculumId) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new NotFoundException("Curriculum with id : "+ curriculumId +" not found"));
        curriculumRepository.delete(curriculum);
        log.info("Deleting curriculum name : " + curriculum.getTitle());
    }

}
