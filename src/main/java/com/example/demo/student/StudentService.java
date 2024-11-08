package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

// Business Logic

public class StudentService {
    public List<Student> getStudents() {
		return List.of(
			new Student(
				1L,
				"Davi",
				19,
				LocalDate.of(2005, 1, 23),
				"davi@gmail.com"
			)
		);
	}
}