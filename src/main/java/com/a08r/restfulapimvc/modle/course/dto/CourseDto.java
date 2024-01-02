package com.a08r.restfulapimvc.modle.course.dto;


import com.a08r.restfulapimvc.modle.course.Course;
import lombok.*;


import java.math.BigDecimal;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private String title;

    private String description;

    private BigDecimal price;
}
