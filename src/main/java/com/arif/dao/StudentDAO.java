package com.arif.dao;

import java.util.List;

import com.arif.model.Student;

public interface StudentDAO {
	 void add(Student student);
	 void edit(Student student);
	 void delete(int studentId);
	 Student getStudent(int studentId);
	 List<Student> getAllStudent();

}
