package kosta.student.service;

import java.util.Scanner;

public interface StudentService {

	void function();
	
	default String strInputData(Scanner sc) {
		String s="";
		try {
			s= sc.nextLine();
		} catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
		}
		return s;
	}
	
	default int intInputData(Scanner sc) {
		int i = 0;
		try {
			i=sc.nextInt();
			sc.nextLine();
		} catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
		}
		return i;
	}
	
	default double doubleInputData(Scanner sc) {
		double d = 0.0;
		try {
			d=sc.nextDouble();
			sc.nextLine();
		} catch(Exception e) {
			System.out.println("알 수 없는 오류가 발생하였습니다.");
		}
		return d;
	}
}
