package com.celyng.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/students")
    public Student post(
            @RequestBody StudentDto dto
    ){
        var student = toStudent(dto);
        return repository.save(student);
    }

    private Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school =  new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);
        return student;
    }

    @GetMapping("/students/all")
    public List<Student> getAllStudent (){
        return repository.findAll();
    }


    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id){
        return repository.findById(id).orElse(new Student());
    }


    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentById(
            @PathVariable("student-name") String name){
        return repository.findAllByFirstNameContaining(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer studentId
    ){
        repository.deleteById(studentId);
    }



}
