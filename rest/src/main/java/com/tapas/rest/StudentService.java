package com.tapas.rest;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Flux<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public Mono<Student> addStudent(Student student){
        student.setId(new ObjectId().toString());
        return studentRepository.save(student);
    }

}
