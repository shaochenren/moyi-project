package com.example.moyiproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
Entities are Java classes that map directly to database tables. They are primarily used within the Data Access Layer and are part of the domain model.
 Each entity instance typically corresponds to a single row in the table,
 and its fields correspond to the columns of the table.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email_id",nullable = false,unique = true)
    private String email;
    @Column(name = "gpa")
    private Long gpa;
}
