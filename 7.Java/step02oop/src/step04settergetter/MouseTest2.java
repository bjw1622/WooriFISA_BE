package step04settergetter;

public class MouseTest2 {

	public static void main(String[] args) {
		Mouse2 mickey = new Mouse2("black");
		// Mouse 클래스의 color 필드는 공개되어 있음
		mickey.setColor("White");
		System.out.println(mickey.getColor());
	}

}
