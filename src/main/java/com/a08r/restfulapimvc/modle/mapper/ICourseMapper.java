package com.a08r.restfulapimvc.model.mapper;


import com.a08r.restfulapimvc.model.course.Course;
import com.a08r.restfulapimvc.model.course.dto.CourseDto;

public interface ICourseMapper {
    Course CourseDtoToCourse(CourseDto addCourseDto);
    CourseDto courseToCourseDto(Course course);
}
