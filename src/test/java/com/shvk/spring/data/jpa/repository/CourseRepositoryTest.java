package com.shvk.spring.data.jpa.repository;

import com.shvk.spring.data.jpa.entity.Course;
import com.shvk.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
            PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
            PageRequest.of(1,2);

        List<Course> courses =
            courseRepository.findAll(secondPageWithTwoRecords)
                .getContent();

        long totalElements =
            courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
            courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
            PageRequest.of(
                0,
                2,
                Sort.by("title")
            );
        Pageable sortByCreditDesc =
            PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
            );

        Pageable sortByTitleAndCreditDesc =
            PageRequest.of(
                0,
                2,
                Sort.by("title")
                    .descending()
                    .and(Sort.by("credit"))
            );

        List<Course> courses
            = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }
}