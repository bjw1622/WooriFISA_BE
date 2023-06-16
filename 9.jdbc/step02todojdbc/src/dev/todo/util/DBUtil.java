package dev.todo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * DB와 관련된 공통 처리 코드들을 별도의 유틸 클래스로 분리
 * */
public class DBUtil {

	public static Connection getConnection() {
		Properties prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream("resources/jdbc.properties");
			prop.load(fs);

			final String DB_URL = prop.getProperty("url"); // DB 서버 접근용 URL
			final String DATABASE_NAME = prop.getProperty("database"); // 접속할 데이터베이스 이름
			// CREATE DATABASE testdb; 했을 때 DATABASE 이름
			final String USER = prop.getProperty("username"); // 접속하는 사용자 계정
			final String PASSWORD = prop.getProperty("password");
			Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			return conn;
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
