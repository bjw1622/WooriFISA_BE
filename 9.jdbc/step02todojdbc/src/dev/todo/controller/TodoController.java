package dev.todo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import com.mysql.cj.protocol.Resultset;

import dev.todo.model.Todo;

import java.sql.Date;

/*
 * Controller - 사용자로부터 동작에 대한 제어, 분기 역할
 * */
public class TodoController {
	private Todo todo;

	final String DB_URL = "jdbc:mysql://localhost:3306/"; // DB 서버 접근용 URL
	final String DATABASE_NAME = "testdb"; // 접속할 데이터베이스 이름

	// CREATE DTABASE testdb; 했을 때 DATABASE 이름
	final String USER = "root"; // 접속하는 사용자 계정
	final String PASSWORD = "1234";
	Connection connection;
	Statement statement;
	ResultSet rs;

	// 전체 Todo 조회
	public void findAll() {
		List<Todo> todos = new ArrayList<>();
		final String selectTodo = "Select * from todo";
		// DB에 접근하는 코드 작성
		try {
			// JDBC 4.0 이전 방식
			// 쿼리 수행 진행시켜
			// 결과 데이터 출력(View)
			connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			statement = connection.createStatement();
			rs = statement.executeQuery(selectTodo);
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Date date = rs.getDate("due_date");
			LocalDate dueDate = date.toLocalDate();
			boolean isCompleted = rs.getBoolean("is_completed");
			todos.add(new Todo(id, title, description, dueDate, isCompleted));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			// 자원 반납 , 해제 (순서 => 역순)
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// Todo 저장

		// Todo 수정

		// Todo 삭제
	}

	// id에 해당하는 한 개의 Todo 데이터 조회
	public Todo findById(int todoNumber) throws SQLException {
		final String selectTodoById = "Select * from todo where id=" + todoNumber;
		connection = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
		statement = connection.createStatement();
		rs = statement.executeQuery(selectTodoById);
		Todo findTodo = null;
		while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Date date = rs.getDate("due_date");
			LocalDate dueDate = date.toLocalDate();
			boolean isCompleted = rs.getBoolean("is_completed");
			findTodo = new Todo(id, title, description, dueDate, isCompleted);
		}
		return findTodo;
	}
}
