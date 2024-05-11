package com.example.moyiproject.service.implement;

import com.example.moyiproject.dto.StudentDto;
import com.example.moyiproject.entity.Student;
import com.example.moyiproject.exception.RescourseNotfoundeception;
import com.example.moyiproject.mapper.Studentmapper;
import com.example.moyiproject.repository.Studentrepo;
import com.example.moyiproject.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImplement implements StudentService {
    private Studentrepo studentrepo;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = Studentmapper.mapToStudent(studentDto);
        Student savedStudent = studentrepo.save(student);

        return Studentmapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentrepo.findById(studentId)
                .orElseThrow(() -> new RescourseNotfoundeception("Student not exist: " + studentId));
        return Studentmapper.mapToStudentDto(student);
    }


    @Override
    public List<StudentDto> findByGpaLessThan(Long studentGpa) {
        List<Student> students = studentrepo.findByGpaLessThan(studentGpa);
        if(students.isEmpty()){
            throw new RescourseNotfoundeception("Student not exist: " + studentGpa);
        }
        return students.stream()
                .map(Studentmapper::mapToStudentDto).filter(studentDto -> studentDto.getGpa() < studentGpa)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> studens = studentrepo.findAll();
        return studens.stream().map((student)->Studentmapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentid, StudentDto updateStudent) {
        Student student = studentrepo.findById(studentid).orElseThrow(()->new RescourseNotfoundeception("STudebt not exsit with that id  " + studentid)
        );
        student.setFirstname(updateStudent.getFirstName());
        student.setLastname(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());
        student.setGpa(updateStudent.getGpa());

        Student updatestudent = studentrepo.save(student);
        return Studentmapper.mapToStudentDto(updatestudent);
    }

    @Override
    public void deletestudent(Long studentid) {
        Student student = studentrepo.findById(studentid).orElseThrow(()->new RescourseNotfoundeception("STudebt not exsit with that id  " + studentid)
        );
        studentrepo.deleteById(studentid);
    }
}
