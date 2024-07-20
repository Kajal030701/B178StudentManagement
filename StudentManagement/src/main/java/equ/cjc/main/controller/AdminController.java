package equ.cjc.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import equ.cjc.main.model.Student;
import equ.cjc.main.service.StudentService;
@Controller
public class AdminController {
	@Autowired
	StudentService ss;
	@RequestMapping("/")
	public String prelogin() {
		return"login";
	}
	@RequestMapping("/login")
	public String onlogin(@RequestParam String username,@RequestParam String password,Model m) {
		if(username.equals("admin")&& password.equals("admin123")){
			List<Student>students=ss.getallstudent();
			m.addAttribute("data",students);
			
			return"adminscreen";
		}else {
			m.addAttribute("login_fail","Enter valid login details.");
			return"login";
		}
	}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		ss.savestudentDetails(s);
		List<Student>students=ss.getallstudent();
		m.addAttribute(students);
		//ss.savedata(s);
		return"adminscreen";
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber,Model m) {
		List<Student>result=ss.searchStudentBybatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data",result);
			}else {
				List<Student>students=ss.getallstudent();
				m.addAttribute("data",students);
				m.addAttribute("message","No record are available for the batch" +batchNumber);
				
			}
		return"adminscreen";
	}
	@RequestMapping("/fees")
	public String onfees(@RequestParam("id")int id,Model m) {
		    Student s=ss.getSingleStudent(id);
		m.addAttribute("st", s);
		return"fees";
	}
	@RequestMapping("/payfees")
	public String payfees(@RequestParam("studentid")int studentid,@RequestParam("ammount")double ammount,Model m) {
		
		ss.updateStudentFees(studentid,ammount);
		List<Student>students=ss.getallstudent();
		m.addAttribute("data",students);
		return "adminscreen";
	}
	
}
