package kosta.student.service;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class StudentInfoAdd implements StudentService {
	StudentManager sm;
	Logger log;
	Scanner sc;

	public StudentInfoAdd(StudentManager sm, Scanner sc, Logger log) {
		this.sm = sm;
		this.sc = sc;
		this.log = log;
	}

	@Override
	public void function() {
		log.info("[���� �Է�] ��ȣ/�̸�/�ּ�/����/��/Ű/����/�г�");
		try {
			log.info(sm.infoAdd(new Student(this.intInputData(sc), this.strInputData(sc), this.strInputData(sc),
					this.strInputData(sc), this.strInputData(sc), this.doubleInputData(sc), this.intInputData(sc),
					this.intInputData(sc))));
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

}
