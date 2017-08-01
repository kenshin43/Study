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
		log.info("[정보 입력] 번호/이름/주소/성별/반/키/나이/학년");
		try {
			log.info(sm.infoAdd(new Student(this.intInputData(sc), this.strInputData(sc), this.strInputData(sc),
					this.strInputData(sc), this.strInputData(sc), this.doubleInputData(sc), this.intInputData(sc),
					this.intInputData(sc))));
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

}
