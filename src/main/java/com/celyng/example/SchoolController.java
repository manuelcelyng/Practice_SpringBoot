package com.celyng.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolRepository repository;
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository repository, SchoolRepository schoolRepository) {
        this.repository = repository;
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){

        var school =  toSchool(dto);
        repository.save(school);
        return dto;

    }

    private School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return repository.findAll().stream().map(this::toSchoolDto).collect(Collectors.toList());
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

}


