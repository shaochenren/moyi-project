package com.example.moyiproject.controller;

import com.example.moyiproject.dto.StudentDto;
import com.example.moyiproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")

public class StudentController {
    private StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    //BUILD get student rest api
    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getstudentByID(@PathVariable("id") Long studetid){
        StudentDto studentDto = studentService.getStudentById(studetid);
        return ResponseEntity.ok(studentDto);
    }
    //Build get all students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getallstudent(){
        List<StudentDto> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }
    //getgpa
    @GetMapping("/gpa/{gpa}")
    public  ResponseEntity<List<StudentDto>> getstudentgpalessthan(@PathVariable("gpa") Long gpanumber){
        List<StudentDto> student = studentService.findByGpaLessThan(gpanumber);
        return ResponseEntity.ok(student);
    }
    //Update
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updatestudent(@PathVariable("id") Long studentid, @RequestBody StudentDto updatestudent){
        StudentDto student = studentService.updateStudent(studentid,updatestudent);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletestudebt(@PathVariable("id")  Long studentid){
        studentService.deletestudent(studentid);
        return ResponseEntity.ok("Studenr delete successfully");
    }
}
