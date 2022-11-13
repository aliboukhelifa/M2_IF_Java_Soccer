package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentEntityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentEntityRepository studentEntityRepository;
    public List<Student> getAll() { return studentEntityRepository.findAll();}
    public Student save(Student s) {
        return studentEntityRepository.save(s);
    }
    
}
