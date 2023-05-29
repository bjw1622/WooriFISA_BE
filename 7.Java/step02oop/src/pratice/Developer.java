package pratice;

public class Developer {
	private String name;
	private byte age;
	private String clothing;
	private String language;
	private String company;
	private int salary;
	private String job;

	public Developer(String name, byte age, String clothing, String language, String company, int salary, String job) {
		super();
		this.name = name;
		if (age < 0) {
			System.out.println("어린척 하지마 !");
			this.age = 20;
		} else {
			this.age = age;
		}

		this.clothing = clothing;
		this.language = language;
		this.company = company;
		this.salary = salary;
		this.job = job;
	}

	public byte getAge() {
		return age;
	}

	public String getJob() {
		return job;
	}

	public int getSalary() {
		return salary;
	}

	public void work() {
		System.out.println(company + "에서 " + language + "를 사용하여 일 합니다");
	}

	public String getName() {
		return name;
	}

	public void cooperate(Developer dev) {
		System.out.println(dev.getJob() + " " + dev.getName() + "과 같이 업무를 합니다.");
	}

	public void setSalary(int year) {
		this.salary = year * getSalary();
	}

}
