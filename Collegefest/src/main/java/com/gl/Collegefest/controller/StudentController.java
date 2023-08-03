package com.gl.Collegefest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.Collegefest.entity.Student;
import com.gl.Collegefest.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;



	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {


		// get Students from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);


		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "student-form";
	}


	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {

		System.out.println("theId = "+theId);
		// get the Student from the service
		Student theStudent = studentService.findById(theId);
		System.out.println("theStudent = "+theStudent.getFname());


		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "student-form";
	}


	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
						   @RequestParam("fname") String fname,
						   @RequestParam("lname") String lname,
						   @RequestParam("course") String course,
						   @RequestParam("country") String country
						   ) {

		System.out.println(id);
		Student theStudent;
		if(id!=0)
		{
			theStudent= studentService.findById(id);
			theStudent.setFname(fname);
			theStudent.setLname(lname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else
			theStudent=new Student(fname, lname, course, country);
		// save the Student
		studentService.save(theStudent);


		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}



	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Student
		studentService.deleteById(theId);

		// redirect to /Student/list
		return "redirect:/students/list";

	}


//	@RequestMapping("/search")
//	public String search(@RequestParam("fname") String fname,
//						 @RequestParam("lname") String lname,
//						 Model theModel) {
//
//		// check names, if both are empty then just give list of all Students
//
//		if (fname.trim().isEmpty() && lname.trim().isEmpty()) {
//			return "redirect:/students/list";
//		}
//		else {
//			// else, search by first name and last name
//			List<Student> theStudents =
//					studentService.searchBy(fname, lname);
//
//			// add to the spring model
//			theModel.addAttribute("Students", theStudents);
//
//			// send to list-Students
//			return "list-students";
//		}
//
//	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
					"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}


















