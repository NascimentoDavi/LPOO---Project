package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    // Create
    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }

    // Read ID
    public Optional<Student> findStudentById (String Id) {
        return studentRepository.findById(Id);
    }

    // Read All Students
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    // Find Student by Name
    public Optional<Student> findStudentByName (String name) {
        return studentRepository.findStudentByName(name);
    }

    // Find Student by E-mail
    public Optional<Student> findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }

    // Count Students by Age
    public long countStudentByAge () {
        return studentRepository.count();
    }

    // Update Student
    public Student updateStudent (String id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setEmail(updatedStudent.getEmail());
            student.setDob(updatedStudent.getDob());
            return studentRepository.save(student);
        }).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Delete Student
    public void deleteStudent (String id) {
        studentRepository.deleteById(id);
    }

}