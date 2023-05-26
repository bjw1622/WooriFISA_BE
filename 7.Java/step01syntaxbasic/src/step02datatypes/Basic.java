package step02datatypes;

public class Basic {

	// 자주색으로 작성된 단어들은 키워드(keyword)
	public static void main(String[] args) {
		// 1. 값의 타입

		// 1-1. 대표적인 기본(Primitive) 타입들
		int apples = 7;
		float eyesight = 1.5f; // java에서 float(실수형) 타입은 뒤에 f를 명시
		char initalLetter = 'Y'; // 하나의 문자에서만 '' 사용 가능
		// 단 한 글자의 '문자' 타입, 홑따옴표만 가능
		String name = "yoo"; // 두 글자 이상의 문자 '열' 타입, 쌍따옴표만 가능
		boolean isChecked = true; // 논리형타입(true/false)

		System.out.println(apples);
		System.out.println(eyesight);
		System.out.println(initalLetter);
		System.out.println(name);
		System.out.println(isChecked);

	}

}
