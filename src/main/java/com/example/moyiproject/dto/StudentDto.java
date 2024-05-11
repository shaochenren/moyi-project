package com.example.moyiproject.dto;
/*
DTOs are simpler objects, designed purely for transferring data between processes or across the layers of an application,
 particularly from the backend to the frontend or between different backend layers.
 They do not contain any business logic but serve as data containers.
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long gpa;

}
