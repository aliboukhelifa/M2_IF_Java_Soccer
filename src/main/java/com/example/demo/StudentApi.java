package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;



@RestController
@AllArgsConstructor

public class StudentApi {
    private final StudentEntityRepository studentEntityRepository;

    // Get All students 
    @GetMapping("students")
    public List<Student> getAll(){
        return studentEntityRepository.findAll(); 
    }

    // Get a student by email 
    @GetMapping("students/email")
    public Student getStudent(@RequestParam String email){
        return studentEntityRepository.findByEmail(email);
    }

    // Get a student by first name 
    @GetMapping("students/a")
    public Student getFirstName(@RequestParam String firstName, @RequestParam String lastName){
        return studentEntityRepository.findByFirstNameAndLastName(firstName, null);
    }

    @PostMapping("students")
    public Student save(@RequestBody Student s){
        return studentEntityRepository.save(s);
    }

    @PutMapping("students")
    public Student update(@RequestBody Student s, @RequestParam String email){
        Optional<Student> student = studentEntityRepository.findById(s.getId());
        student.ifPresent(value -> value.setEmail(email));
        return studentEntityRepository.save(student.orElse(null));
    }

   /*  @DeleteMapping("students/email/{email}")
    public void delete(@PathVariable String email){
        Optional<Student> student = studentEntityRepository.findByEmail(email);
        studentEntityRepository.delete(student.orElse(null));
    } */
}
