package com.shvk.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
        name = "course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
        mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "teacher_id",
        referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}
