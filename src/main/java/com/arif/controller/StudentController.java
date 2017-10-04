package com.arif.controller;

import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arif.model.Student;
import com.arif.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) {
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}

	 @GetMapping("/greeting")
	    public String greetingForm(Model model) {
	        model.addAttribute("greeting", new Student());
	        return "greeting";
	    }
	 
	 @PostMapping("/greeting")
	    public String greetingSubmit(@ModelAttribute Student student) {
	        return "result";
	    }
	 
	@RequestMapping(value = "/student.do", method = RequestMethod.POST)
	public String doSomeThing(@ModelAttribute Student student,
			BindingResult result, @RequestBody  String requestBody,
			Map<String, Object> map) {

		 StringTokenizer st = new StringTokenizer(requestBody);
		 st.nextToken("&");
		 //student.setStudentId(Integer.parseInt(st.nextToken("&")));
		 
		 StringTokenizer st1 = new StringTokenizer(st.nextToken("&"));
		 st1.nextToken("=");
		 student.setStudentName(st1.nextToken("="));
		 
		 st1 = new StringTokenizer(st.nextToken("&"));
		 st1.nextToken("=");
		 student.setStudentSurname(st1.nextToken("="));
		 
		 st1 = new StringTokenizer(st.nextToken("&"));
		 st1.nextToken("=");
		 student.setStudentAddress(st1.nextToken("="));
		 
		 st1 = new StringTokenizer(st.nextToken("&"));
		 st1.nextToken("=");
		 String actions = st1.nextToken("=");
		 
		Student studentResult = new Student();

		if ("add".equalsIgnoreCase(actions.toLowerCase())) {
			studentService.add(student);
			studentResult = student;
		} else if ("edit".equalsIgnoreCase(actions.toLowerCase())) {
			studentService.edit(student);
			studentResult = student;
		} else if ("delete".equalsIgnoreCase(actions.toLowerCase())) {
			studentService.delete(student.getStudentId());
			studentResult = new Student();
		} else if ("search".equalsIgnoreCase(actions.toLowerCase())) {
			Student searched = studentService
					.getStudent(student.getStudentId());
			studentResult = searched == null ? new Student() : searched;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";

	}
}
