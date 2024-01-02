package com.a08r.restfulapimvc.repositores;

import com.a08r.restfulapimvc.modle.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Long> {
}
