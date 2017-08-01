package kosta.student.service;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;

public class StudentSortList implements StudentService {
	
	StudentManager sm;
	Logger log;
	Scanner sc;

	public StudentSortList(StudentManager sm, Scanner sc, Logger log) {
		this.sm = sm;
		this.sc = sc;
		this.log = log;
	}

	@Override
	public void function() {
		log.info("[���� �Է�]1.�̸�2.����3.�ݺ� /���ڿ�");
		sm.listPrint(this.intInputData(sc)).stream().forEach(t->log.info(t.toString()));
	}

}
