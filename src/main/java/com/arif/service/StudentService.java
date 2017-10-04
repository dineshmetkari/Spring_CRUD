package com.arif.service;

import java.util.List;

import com.arif.model.Student;

public interface StudentService {
	 void add(Student student);
	 void edit(Student student);
	 void delete(int studentId);
	 Student getStudent(int studentId);
	 List<Student> getAllStudent();
}
