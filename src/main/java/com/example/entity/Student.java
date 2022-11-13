package com.example.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student{
    @Id
    @GeneratedValue(generator = "student_id_sequence")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age; 
 
    public void addStudent() {
        ArrayList<Student> s = new ArrayList<Student>();
        s.add(new Student(id,"Emmanuel", "LEPINETTE", "lepinette@dauphine.eu", 56));        
    }
    
    
}



