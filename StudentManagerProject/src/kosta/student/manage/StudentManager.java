package kosta.student.manage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kosta.student.vo.Student;

// ���߿� DB�� ������ ����
// LinkedList�� ����
// �����͸� ó���ϴ� Ŭ����
// 7���� �ϳ��� 8���� �ϳ��� ������ ��.
// ��*����� ����� �� �� ����.

public class StudentManager {

	private List<Student> list = new LinkedList<>();

	public String infoAdd(Student s) {
		list.add(s);
		return s.getName() + "�� ������ ���������� �ԷµǾ����ϴ�.";
	} // JDK 7&8�� ����

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
	// JDK 8

	public List<Student> listPrint7(int type) {
		switch (type) {
		case 1:
			list.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			break;
		case 2:
			list.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o2.getScore() - o1.getScore();
				}
			});
			break;
		case 3:
			list.sort(new Comparator<Student>() {
				@Override
				public int compare(Student o1, Student o2) {
					return o1.getClazz().compareTo(o2.getClazz());
				}
			});
			break;
		}
		return list;
	}
	// JDK 7

	public String plusScore(int num, int score) {
		boolean suc = list.stream().filter(t -> t.getNum() == num).peek(t -> t.setScore(score))
				.allMatch(t -> t.getNum() == num);
		String msg = "�����Ͽ����ϴ�.";
		if (suc) {
			msg = "�����Ͽ����ϴ�.";
		}
		return msg;
	}
	// JDK 8

	public String plusScore7(int num, int score) {
		Iterator<Student> it = list.iterator();
		String msg = "�����Ͽ����ϴ�.";

		while (it.hasNext()) {
			Student s = it.next();
			if (s.getNum() == num) {
				s.setScore(score);
				msg = "�����Ͽ����ϴ�.";
			}
		}
		return msg;
	}
	// JDK 7

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
	// JDK 8

	public List<Student> search7(int type, String str) {
		List<Student> searchedList = new LinkedList<Student>();
		Iterator<Student> it = list.iterator();
		switch (type) {
		case 1:
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getName().equals(str)) {
					searchedList.add(s);
				}
			}
			break;
		case 2:
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getAddr().equals(str)) {
					searchedList.add(s);
				}
			}
			break;
		}
		return searchedList;
	}
	// JDK 7

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
	// JDK 8

	public String Statistics7(int type) {
		
		//�ӽ÷� ���� �ϴ� List ��ü
		List<Student> slist = new LinkedList<Student>();
		
		//���� ���� �����ϴ� String
		String statisticedStr = "";
		
		//����� ���� ����
		double total = 0;
		int cnt = 0;
		String str = "";
		
		//����Ʈ�� �ݺ��ؼ� Key ���� �޾ƿɴϴ�.
		Iterator<Student> it = list.iterator();
		
		//�� Ű���� �޾ƿɴϴ�.
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		
		//Ű ���� ���� ��ü�� ���� �����մϴ�.
		while (it.hasNext()) {
			Student s = it.next();
			switch (type) {
			case 1:
				str = s.getGender();
				break;
			case 2:
				str = s.getClazz();
				break;
			case 3:
				str = s.getAddr();
				break;
			case 4:
				str = Integer.toString(s.getYear());
				break;
			}
			//Ű ���� ������ �ش� ��ü���� �����ѵ� �ٽ� Map�� ����
			if (map.containsKey(str)) {
				List<Student> list2 = map.get(str);
				list2.add(s);
				map.put(str, list2);
				//�ƴϸ� ���� �����Ѵ�.
			} else {
				List<Student> tempList = new ArrayList<Student>();
				tempList.add(s);
				map.put(str, tempList);
			}
		}

		Iterator<String> itString = map.keySet().iterator();

		//����Ʈ ���� ����� ���� ����մϴ�.
		while (itString.hasNext()) {
			str = itString.next();
			slist = map.get(str);
			Iterator<Student> it2 = slist.iterator();
			total = 0;
			cnt = 0;
			switch (type) {
			case 1:
				while (it2.hasNext()) {
					Student s = it2.next();
					total += s.getScore();
					cnt++;
				}
				break;
			case 2:
				while (it2.hasNext()) {
					Student s = it2.next();
					total += s.getScore();
					cnt++;
				}
				break;
			case 3:
				while (it2.hasNext()) {
					Student s = it2.next();
					total += s.getScore();
					cnt++;
				}
				break;
			case 4:
				while (it2.hasNext()) {
					Student s = it2.next();
					total += s.getHeight();
					cnt++;
				}
				break;
			}
			statisticedStr += str + " : " + Double.toString((total / cnt));
			statisticedStr += "\n";
		}
		return statisticedStr;
	}
	// JDK7

}
