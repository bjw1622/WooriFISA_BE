package dev.syntax;

public class Step01OOPWay {

	public static void main(String[] args) {
		/*
		 * RDB없이 객체지향만으로 Student와 Major의 관계 구현
		 */
		Student hwang = new Student(1, "철원");
		Student han = new Student(2, "윤서");

		Major computer = new Major(1, "Computer Science");
		hwang.setMajor(computer);
		han.setMajor(computer);
		
		Major majorOfHwang = hwang.getMajor();
		System.out.println(majorOfHwang);
	}
}
