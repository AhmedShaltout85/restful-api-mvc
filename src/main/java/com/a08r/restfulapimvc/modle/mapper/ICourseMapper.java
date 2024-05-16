package com.a08r.restfulapimvc.modle.mapper;


import com.a08r.restfulapimvc.modle.course.Course;
import com.a08r.restfulapimvc.modle.course.dto.CourseDto;

public interface ICourseMapper {
    Course courseDtotocourse(CourseDto addCourseDto);
    CourseDto courseToCourseDto(Course course);
}
