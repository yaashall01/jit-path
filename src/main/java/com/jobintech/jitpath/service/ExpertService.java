package com.jobintech.jitpath.service;

import com.jobintech.jitpath.dto.ExpertDto;
import com.jobintech.jitpath.exception.AlreadyExistsException;
import com.jobintech.jitpath.exception.NotFoundException;
import com.jobintech.jitpath.mapper.ExpertDtoMapper;
import com.jobintech.jitpath.model.Expert;
import com.jobintech.jitpath.repository.ExpertRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ExpertService {

    private final ExpertRepository expertRepository;
    private final ExpertDtoMapper expertDtoMapper;

    public ExpertService(ExpertRepository expertRepository, ExpertDtoMapper expertDtoMapper) {
        this.expertRepository = expertRepository;
        this.expertDtoMapper = expertDtoMapper;
    }


    public ExpertDto getExpertDetails(Long expertId) {
        log.info("Fetching Expert with id "+expertId);
        Expert expert = expertRepository.findById(expertId)
                .orElseThrow(() -> new NotFoundException("Student not found id" + expertId));
        return expertDtoMapper.toDto(expert);
    }

    public List<ExpertDto> getAllExperts() {
        log.info("Fetching all experts");
        return expertDtoMapper.toDtos(expertRepository.findAll());
    }

    public ExpertDto createExpert(ExpertDto expertDto) {
        Expert newExpert = expertDtoMapper.toEntity(expertDto);
        Optional<Expert> existingExpert = expertRepository.findByEmailOrPhoneNumber(newExpert.getEmail(), newExpert.getPhoneNumber());
        if (existingExpert.isPresent()) {
            throw new AlreadyExistsException("Student already exists with email " + expertDto.getEmail());
        }
        Expert savedExpert = expertRepository.save(newExpert);
        log.info("Creating new student named : " + expertDto.getFirstName()+" "+expertDto.getLastName());
        return expertDtoMapper.toDto(savedExpert);
    }

    public ExpertDto updateExpert(Long expertId, ExpertDto expertDto) {
        Expert existingExpert = expertRepository.findById(expertId)
                .orElseThrow(() -> new NotFoundException("Expert not found with id " + expertId));

        existingExpert.setFirstName(expertDto.getFirstName());
        existingExpert.setLastName(expertDto.getLastName());
        existingExpert.setEmail(expertDto.getEmail());
        existingExpert.setPhoneNumber(expertDto.getPhoneNumber());
        existingExpert.setAddress(expertDto.getAddress());
        existingExpert.setDob(expertDto.getDob());

        log.info("Updating expert named : " + expertDto.getFirstName() + " " + expertDto.getLastName());

        return expertDtoMapper.toDto(expertRepository.save(existingExpert));
    }

    public void deleteExpertById(Long expertId) {
        Expert existingExpert = expertRepository.findById(expertId)
                .orElseThrow(() -> new NotFoundException("Expert not found id" + expertId));
        log.info("Deleting expert named : " + existingExpert.getFirstName() + " " + existingExpert.getLastName());
        expertRepository.deleteById(expertId);
    }
}
