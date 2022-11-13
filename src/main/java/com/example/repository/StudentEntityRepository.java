package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;

/* public interface StudentRepository
    extends JpaRepository<Student,Integer> {

  List<Student> findAll();
  Student findById(int id);
  Student findByFirstNameAndLastName(String firstName, String lastName);
}
*/

public interface StudentEntityRepository extends JpaRepository<Student,Integer> {
    public List<Student> findAll();
    public Optional<Student> findById(Integer id);
    public Student findByEmail(String email);
   // public Student findByFirstName(String firstName);
    public Student findByFirstNameAndLastName(String firstName, String lastName);
}


      




