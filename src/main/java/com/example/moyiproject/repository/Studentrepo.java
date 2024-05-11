package com.example.moyiproject.repository;

import com.example.moyiproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Studentrepo extends JpaRepository<Student, Long>{
    List<Student> findByGpaLessThan(Long gpa);

}
