package com.arif.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arif.dao.StudentDAO;
import com.arif.model.Student;

@Repository
public class StudentDaoImpl implements StudentDAO {

	@Autowired
	SessionFactory hibernateSession;

	@Override
	public void add(Student student) {
		hibernateSession.getCurrentSession().save(student);

	}

	@Override
	public void edit(Student student) {
		hibernateSession.getCurrentSession().update(student);

	}

	@Override
	public void delete(int studentId) {
		Student tempStudent = (Student) hibernateSession.getCurrentSession()
				.get(Student.class, studentId);
		hibernateSession.getCurrentSession().delete(tempStudent);

	}

	@Override
	public Student getStudent(int studentId) {
		Student tempStudent = (Student) hibernateSession.getCurrentSession()
				.get(Student.class, studentId);
		return tempStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		return hibernateSession.getCurrentSession()
				.createQuery("from Student").list();
	}

}
