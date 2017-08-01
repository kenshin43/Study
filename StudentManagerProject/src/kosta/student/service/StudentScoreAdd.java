package kosta.student.service;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class StudentScoreAdd implements StudentService {
	StudentManager sm;
	Logger log;
	Scanner sc;

	public StudentScoreAdd(StudentManager sm, Scanner sc, Logger log) {
		this.sm = sm;
		this.sc = sc;
		this.log = log;
	}

	@Override
	public void function() {
		log.info("[���� �Է�] ��ȣ/����");
		try {
			String str = sm.plusScore(this.intInputData(sc), this.intInputData(sc));
			log.info(str);
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

}
