package step01class;

public class Mouse {

	// 멤버 필드
	String name;
	String country;
	int age;
	String religion;
	String address;
	// 멤버 메서드
	void sing() {
		System.out.println("찍찍");
		System.out.println(name + "찍찍");
	}
	// 기본 생성자
	public Mouse() {
		System.out.println("default constructor called");
	}

	public Mouse(int age) {
		System.out.println(this);
		this.age = age;
	}
	public Mouse(String name, String country, int age, String religion,String address) {
		this.name = name;
		this.country = country;
		this.age = age;
		this.religion = religion;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Mouse [name=" + name + ", country=" + country + ", age=" + age + ", religion=" + religion + ", address="
				+ address + "]";
	}
	
}
