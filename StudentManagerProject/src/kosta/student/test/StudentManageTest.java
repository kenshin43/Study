package kosta.student.test;

import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.manage.StudentManager;
import kosta.student.service.StudentInfoAdd;
import kosta.student.service.StudentScoreAdd;
import kosta.student.service.StudentSearch;
import kosta.student.service.StudentService;
import kosta.student.service.StudentSortList;
import kosta.student.service.StudentStatistics;
import kosta.student.vo.Student;

/**
 * 1. �л� ���� �߰�(��ȣ/�̸�/�ּ�/����/��/Ű/����/�г�)
 * 2. ���� ���� �߰�(��ȣ �Է� -> ���� �Է�)
 * 3. �л� ����Ʈ ���
 * 	3.1 �̸��� �������� ����
 * 	3.2 ������ �������� ����
 * 	3.3 �ݺ� ����Ʈ ���
 * 4. �л� ���� �˻�
 * 	4.1 �ּ� �˻�
 * 	4.2 �̸� �˻�
 * 5. ���
 *  5.1 ������ �׷���
 *  5.2 �ݺ� ���� ���
 *  5.3 �ּҺ� ���� ���
 *  5.4 �г⺰ Ű ���
 *  0. ����
 * @author �Ž¿�
 *	Student(int num, String name, String addr, String gender, String clazz, double height, int age, int year)
 *  throw new NullException("");
 */
public class StudentManageTest {
	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		Logger log = Logger.getLogger("");
		Scanner sc = new Scanner(System.in);
		StudentService[] ss = new StudentService[6];
//int num, String name, String addr, String gender, String clazz, double height, int age, int score,int year
		sm.infoAdd(new Student(1,"�̿�ȣ","������","��","A",175.2,25,100,3));
		sm.infoAdd(new Student(2,"������","����Ư����","��","B",160.2,27,96,2));
		sm.infoAdd(new Student(3,"Ƽ�Ĵ�","����Ư����","��","C",162.1,25,55,1));
		sm.infoAdd(new Student(4,"������","��⵵","��","A",194.1,25,76,1));
		sm.infoAdd(new Student(4,"ȫ�浿","��⵵","��","C",170.1,25,67,1));
		sm.infoAdd(new Student(5,"���ȭ","������","��","B",153.3,25,54,2));
		sm.infoAdd(new Student(6,"�̸��","����Ư����","��","B",197.2,25,67,4));
		sm.infoAdd(new Student(7,"���ÿ�","��⵵","��","A",171.5,25,98,1));
		sm.infoAdd(new Student(8,"���ȣ","��⵵","��","C",170,25,13,2));
		sm.infoAdd(new Student(9,"��ź��","������","��","A",175,25,78,3));
		ss[0] = () -> {
			log.info("�ý����� �����մϴ�.");
			System.exit(0);
		};
		ss[1] = new StudentInfoAdd(sm, sc, log);
		ss[2] = new StudentScoreAdd(sm, sc, log);
		ss[3] = new StudentSortList(sm, sc, log);
		ss[4] = new StudentSearch(sm, sc, log);
		ss[5] = new StudentStatistics(sm, sc, log);

		while (true) {
			try {
				log.info("1.�л������߰� | 2. ���������߰� | 3. ����Ʈ ��� | 4. �л� ���� ��� | 5. ��� | 0. ������");
				ss[sc.nextInt()].function();
				;
			} catch (Exception e) {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			}
		}

	}
}
