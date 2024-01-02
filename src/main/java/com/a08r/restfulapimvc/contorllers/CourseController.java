package com.a08r.restfulapimvc.contorllers;

import com.a08r.restfulapimvc.modle.course.dto.CourseDto;
import com.a08r.restfulapimvc.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/course")
public class CourseController {

    private  final ICourseService iCourseService;
    @Autowired
    public CourseController(ICourseService iCourseService) {
        this.iCourseService = iCourseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll(){
     return this.iCourseService.findAll();
    }

    @GetMapping(path ="/{courseId}" )
    public ResponseEntity<CourseDto> findByCourseById(@PathVariable Long courseId){
        return this.iCourseService.findById(courseId);

    }
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto addCourseDto){
        return this.iCourseService.create(addCourseDto);
    }

    @PutMapping(path = "/{courseId}")
    public ResponseEntity<CourseDto> updateCourse(
            @PathVariable Long courseId,
            @RequestBody CourseDto addCourseDto){
        return this.iCourseService.update(courseId, addCourseDto);
    }
    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long courseId){
        return this.iCourseService.remove(courseId);
    }

}
