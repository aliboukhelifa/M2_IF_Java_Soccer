package com.example.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.StudentEntityRepository;

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
    @GetMapping("students/findbyemail")
    public Student getStudent(@RequestParam String email){
        return studentEntityRepository.findByEmail(email);
    }

    // Get a student by first name 
    @GetMapping("students/findbyname")
    public Student getFirstName(@RequestParam String firstName){
        return studentEntityRepository.findByFirstNameAndLastName(firstName, null);
    }

    // Save a new student
    @PostMapping("students/savestudent")
    public Student save(@RequestBody Student s){
        return studentEntityRepository.save(s);
    }

    // Modify the email of a student
    @PutMapping("students/update")
    public Student update(@RequestBody Student s, @RequestParam String email){
        Optional<Student> student = studentEntityRepository.findById(s.getId());
        student.ifPresent(value -> value.setEmail(email));
        return studentEntityRepository.save(student.orElse(null));
    }

    // Delete a student
    @DeleteMapping("students/delete/{student}")
    public void delete(@RequestBody Student s){
        studentEntityRepository.delete(s);
    }
    /* 
    @DeleteMapping("students/delete/{email}")
    public void delete(@PathVariable String email){
        Optional<Student> student = studentEntityRepository.findByEmail(email);
        studentEntityRepository.delete(student.orElse(null));
    }
    */
}
