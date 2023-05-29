package step01class;

public class DisneyWorld {

	public static void main(String[] args) {
		// 미키마우스 생성
		// 참조타입(Mouse) 참조변수 = new 참조타입();
		Mouse mickey = new Mouse();
		
		System.out.println(mickey);
		mickey.name="미키마우스";
		System.out.println(mickey.name);
		mickey.sing();
	}

}
