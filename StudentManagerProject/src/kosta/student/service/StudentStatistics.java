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
		log.info("[���� �Է�] 1���� 2�ݺ� 3�ּҺ� 4�г⺰/���ڿ� �Է�");
		String str = sm.Statistics7(this.intInputData(sc));
		log.info(str);
	}

}
