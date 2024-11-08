package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Return all students
    @GetMapping("/all")
    public List<Student> getAllStudents () {
        return studentService.findAllStudents();
    }

    // Find Student by Id
    public Optional<Student> findStudentById (String id) {
        return studentService.findStudentById(id);
    }
    
    // Find Student by Email
    public Optional<Student> findStudentByEmail (String email) {
        return studentService.findStudentByEmail(email);
    }

    // Create Student
    public Student createStudent (Student student) {
        return studentService.createStudent(student);
    }

    // Count Students by Age
    public long countStudentByAge () {
        return studentService.countStudentByAge();
    }

    // Update Student
    public Student updateStudent (String id, Student updatedStudent) {
        return studentService.updateStudent(id, updatedStudent);
    }

    // Delete Student
    public void deleteStudent (String id) {
        studentService.deleteStudent(id);
    }
}
