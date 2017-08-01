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
 * 1. 학생 정보 추가(번호/이름/주소/성별/반/키/나이/학년)
 * 2. 성적 정보 추가(번호 입력 -> 성적 입력)
 * 3. 학생 리스트 출력
 * 	3.1 이름순 오름차순 정렬
 * 	3.2 성적순 내림차순 정렬
 * 	3.3 반별 리스트 출력
 * 4. 학생 정보 검색
 * 	4.1 주소 검색
 * 	4.2 이름 검색
 * 5. 통계
 *  5.1 성별별 그룹핑
 *  5.2 반별 성적 평균
 *  5.3 주소별 성적 평균
 *  5.4 학년별 키 평균
 *  0. 종료
 * @author 신승엽
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
		sm.infoAdd(new Student(1,"이영호","강원도","남","A",175.2,25,100,3));
		sm.infoAdd(new Student(2,"아이유","서울특별시","여","B",160.2,27,96,2));
		sm.infoAdd(new Student(3,"티파니","서울특별시","여","C",162.1,25,55,1));
		sm.infoAdd(new Student(4,"이제동","경기도","남","A",194.1,25,76,1));
		sm.infoAdd(new Student(4,"홍길동","경기도","남","C",170.1,25,67,1));
		sm.infoAdd(new Student(5,"김민화","강원도","여","B",153.3,25,54,2));
		sm.infoAdd(new Student(6,"이명박","서울특별시","남","B",197.2,25,67,4));
		sm.infoAdd(new Student(7,"김택용","경기도","남","A",171.5,25,98,1));
		sm.infoAdd(new Student(8,"김민호","경기도","남","C",170,25,13,2));
		sm.infoAdd(new Student(9,"방탄소","강원도","남","A",175,25,78,3));
		ss[0] = () -> {
			log.info("시스템을 종료합니다.");
			System.exit(0);
		};
		ss[1] = new StudentInfoAdd(sm, sc, log);
		ss[2] = new StudentScoreAdd(sm, sc, log);
		ss[3] = new StudentSortList(sm, sc, log);
		ss[4] = new StudentSearch(sm, sc, log);
		ss[5] = new StudentStatistics(sm, sc, log);

		while (true) {
			try {
				log.info("1.학생정보추가 | 2. 성적정보추가 | 3. 리스트 출력 | 4. 학생 정보 출력 | 5. 통계 | 0. 나가기");
				ss[sc.nextInt()].function();
			} catch (Exception e) {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}

	}
}
