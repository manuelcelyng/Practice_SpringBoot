package com.celyng.example.student;


import com.celyng.example.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school =  new School();
        school.setId(studentDto.schoolId());

        student.setSchool(school);
        return student;
    }
    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }

}
