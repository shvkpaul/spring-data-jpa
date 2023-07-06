package com.shvk.spring.data.jpa.repository;

import com.shvk.spring.data.jpa.entity.Course;
import com.shvk.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : " + courses);

    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
            .firstName("Subir")
            .lastName("Ghosh")
            .build();

        Course course = Course
            .builder()
            .title("Python")
            .credit(6)
            .teacher(teacher)
            .build();

        courseRepository.save(course);
    }
}