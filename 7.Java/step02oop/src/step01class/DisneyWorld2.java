package step01class;

public class DisneyWorld2 {

	public static void main(String[] args) {
		Mouse disney = new Mouse();
		// 생성자의 이름은 클래스명과 동일해야함
		disney.name = "제리";
		disney.age = 82;
		
		// 인스턴스를 생성할 때 필드를 한 번에 초기화
		Mouse test = new Mouse(2);
		System.out.println(test);
	}
}
