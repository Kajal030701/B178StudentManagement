package equ.cjc.main.service;

import java.util.List;

import equ.cjc.main.model.Student;


public interface StudentService {

	void savedata(Student s);

	public List<Student> getallstudent();

	void savestudentDetails(Student s);
	public List<Student>searchStudentBybatch(String BatchNumber);

	Student getSingleStudent(int id);

	void updateStudentFees(int studentId, double ammount);
	

}
