package com.celyng.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    //WHICH service we want to test
    @InjectMocks
    private StudentService studentService;

    //Declare the dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_sucessfully_save_a_student() {
        //Given
        StudentDto studentDto =  new StudentDto(
                "Manuel",
                "Cely",
                "manuel@gmail.com",
                1
        );

        Student student = new Student(
                "Manuel",
                "Cely",
                "manuel@gmail.com",
                20
        );

        Student savedStudent = new Student(
                "Manuel",
                "Cely",
                "manuel@gmail.com",
                20
        );
        savedStudent.setId(1); // this id se simula que es agregado por la base de datos :D

        StudentResponseDto studentResponseDto = new StudentResponseDto(
                "Manuel",
                "Cely",
                "manuel@gmail.com"
        );
        // Mock the calls
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent)).thenReturn(studentResponseDto);
        //repository.save(student);

        //When
        StudentResponseDto responseDto = studentService.saveStudent(studentDto);

        //Then

        assertNotNull(studentDto.firstName(), responseDto.firstName());
        assertNotNull(studentDto.lastName(), responseDto.lastName());
        assertNotNull(studentDto.email(), responseDto.email());

        verify(studentMapper,times(1))
                .toStudent(studentDto);
        verify(studentRepository,times(1))
                .save(student);
        verify(studentMapper,times(1))
                .toStudentResponseDto(savedStudent);

    }

    @Test
    public void should_get_all_students_by_name(){
        //Given
        Student student = new Student();
        student.setId(1);
        student.setFirstName("Manuel");
        student.setLastName("Cely");
        student.setEmail("manuel@gmail.com");

        StudentResponseDto studentResponseDto = new StudentResponseDto(
                "Manuel",
                "Cely",
                "manuel@gmail.com"
        );

        List<Student> studentsList = new ArrayList<>();
        studentsList.add(student);

        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        studentResponseDtoList.add(studentResponseDto);

        //MockTheCalls
        when(studentMapper.toStudentResponseDto(student)).thenReturn(studentResponseDto);
        when(studentRepository.findAllByFirstNameContaining("Manuel")).thenReturn(studentsList);

        //When

        List<StudentResponseDto> responseDtoList = studentService.getStudentsByName("Manuel");

        //Then
        assertArrayEquals(responseDtoList.toArray(), studentResponseDtoList.toArray());
    }
}