package io.hitesh.learning.ms.studentservice.controller;

import io.hitesh.learning.ms.studentservice.entity.Student;
import io.hitesh.learning.ms.studentservice.repo.StudentRepo;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Data
@RequestMapping("/student")
public class StudentController {
    private final StudentRepo repo;
    @PostMapping("/")
    public Student createStudent(@RequestBody Student student){
        return this.repo.save(student);
    }
    @GetMapping("/")
    public List<Student> getAll(){
        return this.repo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return this.repo.findById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudentById(Long id){
        this.repo.deleteById(id);
    }
}
