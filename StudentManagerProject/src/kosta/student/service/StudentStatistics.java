package kosta.student.service;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;

public class StudentStatistics implements StudentService {
	
	StudentManager sm;
	Logger log;
	Scanner sc;

	public StudentStatistics(StudentManager sm, Scanner sc, Logger log) {
		this.sm = sm;
		this.sc = sc;
		this.log = log;
	}
	@Override
	public void function() {
		log.info("[정보 입력] 1성별 2반별 3주소별 4학년별/문자열 입력");
		String str = sm.Statistics(this.intInputData(sc), this.strInputData(sc));
		log.info(str);
	}

}
