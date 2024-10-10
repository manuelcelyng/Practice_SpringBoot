package com.celyng.example.school;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    SchoolMapper schoolMapper;
    SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school =  schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .toList();
    }

}
