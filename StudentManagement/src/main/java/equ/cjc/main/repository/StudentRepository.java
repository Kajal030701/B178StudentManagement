package equ.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import equ.cjc.main.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllByBatchNumber(String batchNumber);

}
