package com.jobintech.jitpath.mapper;

import com.jobintech.jitpath.dto.ExpertDto;
import com.jobintech.jitpath.dto.StudentDto;
import com.jobintech.jitpath.model.Expert;
import com.jobintech.jitpath.model.Student;
import com.jobintech.jitpath.utils.CredentialsUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Scope("singleton")
public class ExpertDtoMapper implements EntityDtoMapper<Expert, ExpertDto>{
    @Override
    public ExpertDto toDto(Expert expert) {
        return ExpertDto.builder()
                .firstName(expert.getFirstName())
                .lastName(expert.getLastName())
                .email(expert.getEmail())
                .phoneNumber(expert.getPhoneNumber())
                .dob(expert.getDob())
                .address(expert.getAddress())
                .dateOfRegistration(expert.getDateOfRegistration())
                .lastLogin(expert.getLastLogin())
                .build();
    }

    @Override
    public Expert toEntity(ExpertDto dto) {
        if (dto == null) {
            return null;
        }

        Expert expert = new Expert();
        expert.setFirstName(dto.getFirstName());
        expert.setLastName(dto.getLastName());
        expert.setEmail(CredentialsUtil.generateEmail(dto.getFirstName(), dto.getLastName()));
        expert.setPhoneNumber(dto.getPhoneNumber());
        expert.setPassword(CredentialsUtil.generateSecurePassword(8));
        expert.setAddress(dto.getAddress());
        expert.setDob(dto.getDob());
        expert.setDateOfRegistration(LocalDate.now());
        expert.setLastLogin(LocalDate.now());

        /* Curriculum curriculum = new Curriculum();
        curriculum.setId(dto.getCurriculumId());
        student.setCurriculum(curriculum);
         */
        return expert;
    }
}
