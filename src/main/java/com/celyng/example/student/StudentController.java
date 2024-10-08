package com.celyng.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private  final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ){
        return studentService.saveStudent(dto);
    }



    @GetMapping("/students/all")
    public List<StudentResponseDto> getAllStudent (){
        return studentService.getAllStudents();
    }


    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(
            @PathVariable("student-id") Integer id){
        return studentService.getStudentById(id);
    }


    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("student-name") String name){
        return studentService.getStudentsByName(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer studentId
    ){
        studentService.deleteStudentById(studentId);
    }



}
