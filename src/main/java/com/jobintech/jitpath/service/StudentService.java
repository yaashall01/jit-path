package com.jobintech.jitpath.service;

import com.jobintech.jitpath.dto.StudentDto;
import com.jobintech.jitpath.exception.AlreadyExistsException;
import com.jobintech.jitpath.exception.NotFoundException;
import com.jobintech.jitpath.mapper.StudentDtoMapper;
import com.jobintech.jitpath.model.Student;
import com.jobintech.jitpath.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {


    private final StudentRepository studentRepository;
    private final StudentDtoMapper studentDtoMapper;

    public StudentService(StudentRepository studentRepository, StudentDtoMapper studentDtoMapper) {
        this.studentRepository = studentRepository;
        this.studentDtoMapper = studentDtoMapper;
    }


    public StudentDto getStudentDetails(Long studentId) {
        log.info("Fetching Student with id "+studentId);
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found id" + studentId));
        return studentDtoMapper.toDto(student);

    }

    public List<StudentDto> getAllStudents() {
        log.info("Fetching all students");
        return studentDtoMapper.toDtos(studentRepository.findAll());
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student newStudent = studentDtoMapper.toEntity(studentDto);
        Optional<Student> existingStudent = studentRepository.findByEmailOrPhoneNumber(newStudent.getEmail(), newStudent.getPhoneNumber());
        if (existingStudent.isPresent()) {
            throw new AlreadyExistsException("Student already exists with email " + studentDto.getEmail());
        }
        Student savedStudent = studentRepository.save(newStudent);
        log.info("Creating new student named : " + studentDto.getFirstName()+" "+studentDto.getLastName());
        return studentDtoMapper.toDto(savedStudent);
    }

    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found with id " + studentId));
        existingStudent.setFirstName(studentDto.getFirstName());
        existingStudent.setLastName(studentDto.getLastName());
        existingStudent.setEmail(studentDto.getEmail());
        existingStudent.setPhoneNumber(studentDto.getPhoneNumber());
        existingStudent.setAddress(studentDto.getAddress());
        existingStudent.setDob(studentDto.getDob());
        log.info("Updating student named : " + studentDto.getFirstName()+" "+studentDto.getLastName());
        return studentDtoMapper.toDto(studentRepository.save(existingStudent));
    }

    public void deleteStudentById(Long studentId) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Student not found id" + studentId));
        log.info("Deleting new student named : " + existingStudent.getFirstName()+" "+existingStudent.getLastName());
        studentRepository.deleteById(studentId);
    }


}
