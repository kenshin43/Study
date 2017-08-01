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

	@Override
	public int intInputData(Scanner sc) {
		int x;
		while (true) {
			x = StudentService.super.intInputData(sc);
			if (x >= 0 && x < 1000) {
				break;
			}
			System.out.println("범위에 맞게 다시 입력해 주세요.");
		}
		return x;
	}

	@Override
	public double doubleInputData(Scanner sc) {
		double d;
		while (true) {
			d = StudentService.super.doubleInputData(sc);
			if (d >= 0 && d <= 200) {
				break;
			}
			System.out.println("키를 현실성에 맞게 다시 입력해 주세요.");
		}
		return d;
	}

}
