package com.example.moyiproject.service;

import com.example.moyiproject.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> findByGpaLessThan(Long studentGpa);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentid, StudentDto updateStudent);

    void deletestudent(Long studentid);
}
