package com.jobintech.jitpath.mapper;

import com.jobintech.jitpath.dto.StudentDto;
import com.jobintech.jitpath.model.Student;
import com.jobintech.jitpath.model.User;
import com.jobintech.jitpath.utils.CredentialsUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentDtoMapper implements EntityDtoMapper<Student, StudentDto>{

    @Override
    public StudentDto toDto(Student student) {
        return StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .dob(student.getDob())
                .address(student.getAddress())
                .dateOfRegistration(student.getDateOfRegistration())
                .lastLogin(student.getLastLogin())
                .build();
    }

    @Override
    public Student toEntity(StudentDto dto) {
        if (dto == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(CredentialsUtil.generateEmail(dto.getFirstName(), dto.getLastName()));
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setPassword(CredentialsUtil.generateSecurePassword(8));
        student.setAddress(dto.getAddress());
        student.setDob(dto.getDob());
        student.setDateOfRegistration(LocalDate.now());
        student.setLastLogin(LocalDate.now());

        /* Curriculum curriculum = new Curriculum();
        curriculum.setId(dto.getCurriculumId());
        student.setCurriculum(curriculum);
         */
        return student;
    }
}
