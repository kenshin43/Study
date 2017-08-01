package kosta.student.service;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class StudentSearch implements StudentService{
	
	StudentManager sm;
	Logger log;
	Scanner sc;

	public StudentSearch(StudentManager sm, Scanner sc, Logger log) {
		this.sm = sm;
		this.sc = sc;
		this.log = log;
	}

	@Override
	public void function() {
		log.info("[정보 입력] 1 이름2 주소/문자열 입력");
		List<Student> sortedList = sm.search(this.intInputData(sc), this.strInputData(sc));
		sortedList.stream().forEach(t->log.info(t.toString()));
	}

}
