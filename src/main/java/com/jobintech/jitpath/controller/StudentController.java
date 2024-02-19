package com.jobintech.jitpath.controller;


import com.jobintech.jitpath.dto.StudentDto;
import com.jobintech.jitpath.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/details/{studentId}")
    public StudentDto getStudentDetails(@PathVariable Long studentId) {
        return studentService.getStudentDetails(studentId);
    }

    @GetMapping("/all")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public StudentDto createStudent(@RequestBody StudentDto studentDto){
        return studentService.createStudent(studentDto);
    }

    @PutMapping("/update/{studentId}")
    public StudentDto updateStudentById(@PathVariable Long studentId, @RequestBody StudentDto studentDto){
        return studentService.updateStudent(studentId, studentDto);
    }

    @DeleteMapping("/delete/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
    }



}
