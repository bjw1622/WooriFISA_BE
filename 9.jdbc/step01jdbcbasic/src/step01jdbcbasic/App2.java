package step01jdbcbasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
		final String DATABASE_NAME = "testdb"; // 접속할 데이터베이스 이름
		
		// CREATE DTABASE testdb; 했을 때 DATABASE 이름
		final String USER = "root"; // 접속하는 사용자 계정
		final String PASSWORD = "1234";
		
		// JDBC 4.0 이전 방식, 이후는 자동으로 연결됨
		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			// JDBC 4.0 이전 방식
			Class.forName(DRIVER_NAME);
			
			Connection connection = DriverManager.getConnection(DB_URL+DATABASE_NAME,USER,PASSWORD);
			
			System.out.println(connection);
			
			// 쿼리 수행
			
			// 쿼리문 전달해주는 역할
			Statement statement = connection.createStatement();
			
			final String dropTableQueryIfExists = "create table todo (val INT)";
			// 쿼리 수행 진행시켜
			statement.execute(dropTableQueryIfExists);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
