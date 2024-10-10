package com.celyng.example.student;

import com.celyng.example.school.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto =  new StudentDto(
                "manuel",
                "cely",
                "manuel@gmail.com",
                1
        );

        Student student  = studentMapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {
        var msg = assertThrows(NullPointerException.class, () -> studentMapper.toStudent(null));
        assertEquals("The student Dto should not be null", msg.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        //Given
        Student student =  new Student();
        student.setFirstName("manuel");
        student.setLastName("cely");
        student.setEmail("manuel@gmail.com");
        student.setAge(20);
        //When
        StudentResponseDto dto = studentMapper.toStudentResponseDto(student);

        //Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
    }
}