package com.a08r.restfulapimvc.services;


import com.a08r.restfulapimvc.errors.RecordNotFoundException;
import com.a08r.restfulapimvc.modle.course.Course;
import com.a08r.restfulapimvc.modle.course.dto.CourseDto;
import com.a08r.restfulapimvc.modle.mapper.CourseMapperImp;
import com.a08r.restfulapimvc.modle.mapper.ICourseMapper;
import com.a08r.restfulapimvc.repositores.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {
    private final ICourseRepository iCourseRepository;
    private static final ICourseMapper mI_COURSE_MAPPER = new CourseMapperImp();

    @Autowired
    public CourseServiceImpl(ICourseRepository iCourseRepository) {
        this.iCourseRepository = iCourseRepository;
    }

    @Override
    public ResponseEntity<List<CourseDto>> findAll() {
        List<Course> course = iCourseRepository.findAll();
        List<CourseDto> courseDtoList = course
//               .stream().
//               map((Course course1) -> mI_COURSE_MAPPER.courseToCourseDto(course1))
//               .collect(Collectors.toList());
                .stream()
                .map(mI_COURSE_MAPPER::courseToCourseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> findById(Long id) {

        Optional<Course> course = this.iCourseRepository.findById(id);
        if(course.isEmpty()){
            throw new RecordNotFoundException("the item with id: "+id +" not found!....");
        }
        CourseDto courseDto = mI_COURSE_MAPPER.courseToCourseDto(course.get());
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> create(CourseDto addCourseDto) {
        final Course course = mI_COURSE_MAPPER.CourseDtoToCourse(addCourseDto);
        final  Course createCourse = this.iCourseRepository.save(course);
        CourseDto courseDto = mI_COURSE_MAPPER.courseToCourseDto(createCourse);
        return new ResponseEntity<>(courseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CourseDto> update(Long id, CourseDto newCourse) {
        Optional<Course>  course = this.iCourseRepository.findById(id);
        if(course.isEmpty()){
            throw new RecordNotFoundException("the item with id: "+id +" not found!...");
        }
        Course exitingCourse = course.get();
        exitingCourse.setTitle(newCourse.getTitle());
        exitingCourse.setDescription(newCourse.getDescription());
        exitingCourse.setPrice(newCourse.getPrice());
        Course updateCourse = this.iCourseRepository.save(exitingCourse);
        CourseDto courseDto = mI_COURSE_MAPPER.courseToCourseDto(updateCourse);
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        boolean exists = iCourseRepository.existsById(id);
        if(!exists){
            throw new RecordNotFoundException("the item with id: "+id +" not found!....");
        }
       this.iCourseRepository.deleteById(id);
        return new ResponseEntity<>("the item has been deleted successfully!",HttpStatus.NO_CONTENT);
    }
}
