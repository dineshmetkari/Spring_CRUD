package com.arif.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arif.dao.StudentDAO;
import com.arif.model.Student;
import com.arif.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@Transactional
	public void add(Student student) {
		studentDAO.add(student);
	}

	@Transactional
	public void edit(Student student) {
		studentDAO.edit(student);

	}

	@Transactional
	public void delete(int studentId) {
		studentDAO.delete(studentId);
	}

	@Transactional
	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);

	}

	@Transactional
	public List<Student> getAllStudent() {
		return studentDAO.getAllStudent();

	}

}
