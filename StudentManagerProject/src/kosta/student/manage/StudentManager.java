package kosta.student.manage;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import kosta.student.vo.Student;

public class StudentManager {

	List<Student> list = new LinkedList<>();

	public String infoAdd(Student s) {
		list.add(s);
		return s.getName() + "�� ������ ���������� �ԷµǾ����ϴ�.";
	}

	public List<Student> listPrint(int type) {
		List<Student> sortedList = null;
		switch (type) {
		case 1:
			sortedList = list.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
					.collect(Collectors.toList());
			break;
		case 2:
			sortedList = list.stream().sorted((o1, o2) -> o2.getScore() - o1.getScore()).collect(Collectors.toList());
			break;
		case 3:
			sortedList = list.stream().sorted((o1, o2) -> o1.getClazz().compareTo(o2.getClazz()))
					.collect(Collectors.toList());
			break;
		}
		return sortedList;
	}

	public String plusScore(int num, int score) {
		boolean suc = list.stream().filter(t -> t.getNum() == num).peek(t -> t.setScore(score))
				.allMatch(t -> t.getNum() == num);
		String msg = "�����Ͽ����ϴ�.";
		if (suc) {
			msg = "�����Ͽ����ϴ�.";
		}
		return msg;
	}

	public List<Student> search(int type, String str) {
		List<Student> searchedList = null;
		switch (type) {
		case 1:
			searchedList = list.stream().filter(t -> t.getName().equals(str)).collect(Collectors.toList());
			break;
		case 2:
			searchedList = list.stream().filter(t -> t.getAddr().equals(str)).collect(Collectors.toList());
			break;
		}
		return searchedList;
	}

	public String Statistics(int type, String str) {
		String statisticedStr = "";
		switch (type) {
		case 1:
			List<Student> slist = list.stream().filter(t -> t.getGender().equals(str)).collect(Collectors.toList());
			StringBuffer sb = new StringBuffer();
			for (Student s : slist) {
				sb.append(s.toString());
			}
			statisticedStr = sb.toString();
			break;
		case 2:
			statisticedStr = new Double(list.stream().filter(t -> t.getClazz().equals(str)).mapToInt(Student::getScore)
					.average().getAsDouble()).toString();
			break;
		case 3:
			statisticedStr = new Double(list.stream().filter(t -> t.getAddr().equals(str)).mapToInt(Student::getScore)
					.average().getAsDouble()).toString();
			break;
		case 4:
			statisticedStr = new Double(list.stream().filter(t -> new Integer(t.getYear()).toString().equals(str))
					.mapToDouble(Student::getHeight).average().getAsDouble()).toString();
			break;
		}
		return statisticedStr;
	}
	// ���߿� DB�� ������ ����
	// LinkedList�� ����
	// �����͸� ó���ϴ� Ŭ����
	// 7���� �ϳ��� 8���� �ϳ��� ������ ��.
	// ��*����� ����� �� �� ����.
}
