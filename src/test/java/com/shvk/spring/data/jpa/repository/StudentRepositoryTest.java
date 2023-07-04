package com.shvk.spring.data.jpa.repository;

import com.shvk.spring.data.jpa.entity.Guardian;
import com.shvk.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
//            .guardianName("Sunil")
//            .guardianEmail("sunil@gmail.com")
//            .guardianMobile("987654321")
            .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
            .email("Sandhya@gmail.com")
            .name("Sandhya")
            .mobile("987584789")
            .build();

        Student student = Student.builder()
            .firstName("Bikram")
            .lastName("Paul")
            .emailId("bikram@gmail.com")
            .guardian(guardian)
            .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent() {
        List<Student> studentList =
            studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students =
            studentRepository.findByFirstName("Shouvik");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students =
            studentRepository.findByFirstNameContaining("sh");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByLastNameNotNull() {

        List<Student> students =
            studentRepository.findByLastNameNotNull();

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName() {

        List<Student> students =
            studentRepository.findByGuardianName("Sandhya");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {

        Student student =
            studentRepository.findByFirstNameAndLastName("Bikram","Paul");

        System.out.println("student = " + student);
    }
}