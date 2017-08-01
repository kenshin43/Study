package kosta.student.vo;

/**
 * 학생 정보를 저장하는 클래스
 * 
 * @author 신승엽
 *
 */
public class Student {
	private int num;
	private String name = "";
	private String addr = ""; // 서울/경기/충남
	private String gender = "";// 남/여
	private String clazz = ""; // A/B/C
	private double height;
	private int age;
	private int score;
	private int year; // 학년, 1/2/3/4

	// 학점 반환, A,B,C,D,F
	public String getGrade() {
		return "";
	}
	// 더 추가해도 됨!

	public int getNum() {
		return num;
	}

	public Student() {
		super();
	}

	public Student(int num, String name, String addr, String gender, String clazz, double height, int age, int year) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.clazz = clazz;
		this.height = height;
		this.age = age;
		this.year = year;
	}
	
	

	public Student(int num, String name, String addr, String gender, String clazz, double height, int age, int score,
			int year) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.gender = gender;
		this.clazz = clazz;
		this.height = height;
		this.age = age;
		this.score = score;
		this.year = year;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", addr=" + addr + ", gender=" + gender + ", clazz=" + clazz
				+ ", height=" + height + ", age=" + age + ", score=" + score + ", year=" + year + "]";
	}

}
