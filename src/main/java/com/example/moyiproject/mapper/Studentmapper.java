package com.example.moyiproject.mapper;
/*
The primary role of this mapper is to facilitate the conversion between the entity model (Student) and the Data Transfer Object (DTO) model (StudentDto).
This is an essential practice in many applications to separate the database model from the models used in business logic and data exchange
 */
import com.example.moyiproject.dto.StudentDto;
import com.example.moyiproject.entity.Student;

public class Studentmapper {
    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstname(),
                student.getLastname(),
                student.getEmail(),
                student.getGpa()
        );
    }
    public static Student mapToStudent(StudentDto studentDto){
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getGpa()
        );
    }
}
