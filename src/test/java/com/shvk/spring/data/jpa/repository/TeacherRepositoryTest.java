package com.shvk.spring.data.jpa.repository;

import com.shvk.spring.data.jpa.entity.Course;
import com.shvk.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA =
            Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava =
            Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher =
            Teacher.builder()
                .firstName("Ashok")
                .lastName("Das")
                .courses(List.of(courseDBA,courseJava))
                .build();

        teacherRepository.save(teacher);
    }

}