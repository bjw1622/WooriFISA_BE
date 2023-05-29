package step04settergetter;

public class Mouse2 {
	private String color;

	public Mouse2(String color) {
		this.color = color;
	}

	// setter 메서드
	public void setColor(String color) {
		if (color == "White") {
			System.out.println("너 누구야!!");
			return;
		}
		this.color = color;
	}

	// getter 메서드
	public String getColor() {
		return this.color;
	}
}
