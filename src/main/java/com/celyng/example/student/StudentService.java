package com.celyng.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;


    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    public StudentResponseDto saveStudent(
            StudentDto studentDto
    ){
        var student = mapper.toStudent(studentDto);
        var saveStudent = repository.save(student);
        return mapper.toStudentResponseDto(saveStudent);
    }

    public List<StudentResponseDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map((mapper::toStudentResponseDto))
                .collect(Collectors.toList());
    }


    public StudentResponseDto getStudentById(Integer id) {
        return repository.findById(id)
                .map((mapper::toStudentResponseDto))
                .orElse(null);
    }



    public List<StudentResponseDto> getStudentsByName(String name) {
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(mapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }


    public void deleteStudentById(Integer id) {
        repository.deleteById(id);
    }


}
