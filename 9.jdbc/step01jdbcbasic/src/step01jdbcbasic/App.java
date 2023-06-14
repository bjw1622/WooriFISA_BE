package step01jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	// Java 프로그램과 DB 서버와 연결
	public static void main(String[] args) {
		// Java 프로그램과 DB 서버와 연결하는 작업
		
		// 1. DB와 연결 시 필요한 정보 작성
		final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
		final String DATABASE_NAME = "testdb"; // 접속할 데이터베이스 이름
		
		// CREATE DTABASE testdb; 했을 때 DATABASE 이름
		final String USER = "root"; // 접속하는 사용자 계정
		final String PASSWORD = "1234";
		
		
		// 2. DB 연결 코드 작성
		try {
			Connection connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			// DB와의 커넥션(연결) 객체
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
