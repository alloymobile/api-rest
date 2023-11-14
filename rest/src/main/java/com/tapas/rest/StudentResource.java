package com.tapas.rest;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public Flux<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/students/name")
    public Mono<Student> getStudentByName(@RequestParam String name){
        return studentService.getStudentByName(name);
    }

    @PostMapping(value = "/students")
    public Mono<Student> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
}
