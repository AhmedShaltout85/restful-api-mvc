package com.a08r.restfulapimvc.services;


import com.a08r.restfulapimvc.modle.course.dto.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICourseService {
    ResponseEntity<List<CourseDto>> findAll();
    ResponseEntity<CourseDto> findById(Long id);
    ResponseEntity<CourseDto> create(CourseDto CourseDto);
    ResponseEntity<CourseDto> update(Long id, CourseDto addCourseDto);
    ResponseEntity<String> remove(Long id);

}
