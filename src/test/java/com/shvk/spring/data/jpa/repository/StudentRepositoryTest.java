package com.shvk.spring.data.jpa.repository;

import com.shvk.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
            .emailId("shvk@gmail.com")
            .firstName("Shouvik")
            .lastName("Paul")
            .guardianName("Sunil")
            .guardianEmail("sunil@gmail.com")
            .guardianMobile("987654321")
            .build();

        studentRepository.save(student);
    }
}