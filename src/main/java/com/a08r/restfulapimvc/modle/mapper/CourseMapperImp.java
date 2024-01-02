package com.a08r.restfulapimvc.modle.mapper;


import com.a08r.restfulapimvc.modle.course.Course;
import com.a08r.restfulapimvc.modle.course.dto.CourseDto;

public class CourseMapperImp implements ICourseMapper{
    @Override
    public Course CourseDtoToCourse(CourseDto CourseDto) {
        Course course = new Course();
        course.setTitle(CourseDto.getTitle());
        course.setDescription(CourseDto.getDescription());
        course.setPrice(CourseDto.getPrice());

        return course;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
//        CourseDto  courseDto = new CourseDto(course);
        CourseDto courseDto = new CourseDto();
        courseDto.setTitle(course.getTitle());
        courseDto.setDescription(course.getDescription());
        courseDto.setPrice(course.getPrice());
        return courseDto;
    }



}
