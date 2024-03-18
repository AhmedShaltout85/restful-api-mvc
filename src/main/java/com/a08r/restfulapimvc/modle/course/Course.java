package com.a08r.restfulapimvc.modle.course;

import com.a08r.restfulapimvc.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Course extends BaseEntity {
    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;
    @NotBlank(message = "Description is mandatory")
    @Column(name = "description")
    private String description;
    @NotBlank(message = "Price is mandatory")
    @Column(name = "price")
    private BigDecimal price;


}
