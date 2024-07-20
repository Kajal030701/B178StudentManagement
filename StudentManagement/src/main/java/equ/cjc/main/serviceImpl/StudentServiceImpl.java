package equ.cjc.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import equ.cjc.main.model.Student;
import equ.cjc.main.repository.StudentRepository;
import equ.cjc.main.service.StudentService;
@Service
public class StudentServiceImpl implements  StudentService {
	@Autowired
    StudentRepository sr;
	@Override
	public void savedata(Student s) {
		sr.save(s);
	}
	@Override
	public List<Student> getallstudent(){
		return sr.findAll();
	}
	@Override
	public void savestudentDetails(Student s) {
		sr.save(s);
		
	}
	@Override
	public List<Student> searchStudentBybatch(String batchNumber) {
		List<Student>batchStudents=sr.findAllByBatchNumber(batchNumber);
		return batchStudents;
	}
	@Override
	public Student getSingleStudent(int id) {
		Optional<Student>opstudent=sr.findById(id);
		return opstudent.get() ;
	}
	@Override
	public void updateStudentFees(int studentId, double ammount) {
		Optional<Student>opstudent=sr.findById(studentId);
		Student st=opstudent.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
	}

}
