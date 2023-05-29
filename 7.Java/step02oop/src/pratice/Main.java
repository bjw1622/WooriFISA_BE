package pratice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Developer frontEnd = new Developer("정민성", (byte) -25, "절 룩", "JavaScript for Nuxt", "NAVER", 7000, "FrontEnd");
		Developer backEnd = new Developer("김승연", (byte) 25, "검정 룩", "Java for Spring", "WooriBank", 5000, "BackEnd");
		Developer aiDev = new Developer("백재원", (byte) 27, "개발자 룩", "Python for ml", "open AI", 10000,
				"MachineLearning");
		System.out.println("직업: " + frontEnd.getJob());
		System.out.println("1년차 연봉: " + frontEnd.getSalary());
		System.out.println("나이: " + frontEnd.getAge());
		frontEnd.work();
		frontEnd.cooperate(backEnd);
		frontEnd.setSalary(2);
		System.out.println("2년차 연봉: " + frontEnd.getSalary());

		System.out.println("-----------------------");

		backEnd.cooperate(frontEnd);
		backEnd.work();
		backEnd.setSalary(10);
		System.out.println("10년차 연봉: " + backEnd.getSalary());

		System.out.println("-----------------------");

		aiDev.cooperate(backEnd);
		aiDev.work();
		aiDev.setSalary(2);
		System.out.println("2년차 연봉: " + aiDev.getSalary());
	}

}
