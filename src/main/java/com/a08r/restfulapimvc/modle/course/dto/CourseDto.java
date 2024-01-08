package com.a08r.restfulapimvc.model.course.dto;


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
