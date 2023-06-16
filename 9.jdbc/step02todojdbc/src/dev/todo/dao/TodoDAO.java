package dev.todo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dev.todo.model.Todo;
import dev.todo.util.DBUtil;

// DAO, Data Access Object의 줄임말
public class TodoDAO {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public List<Todo> findAll() {

		List<Todo> todos = new ArrayList<>();

//		final String selectQuery = "SELECT * FROM todo";

		try {
			// MyBatis
			Properties prop = new Properties();
			prop.loadFromXML(new FileInputStream("resources/sql_mapper.xml"));
			final String selectQuery = prop.getProperty("getTodos");
			// DB와의 연결 객체 생성
			connection = DBUtil.getConnection();

			// 쿼리 전달해주는 객체
			statement = connection.createStatement();

			// 결과 데이터 출력(View)
			resultSet = statement.executeQuery(selectQuery); // 쿼리 수행

			while (resultSet.next()) { // 다음 행이 존재하는지 확인
//            System.out.print("title = " + resultSet.getString(2)); // 두번째 컬럼인 "title" 데이터에 해당한다.

				int id = resultSet.getInt("id");

				String title = resultSet.getString("title");

				String description = resultSet.getString("description");

				Date date = resultSet.getDate("due_date");
				LocalDate dueDate = date.toLocalDate();

				Boolean isCompleted = resultSet.getBoolean("is_completed");

				todos.add(new Todo(id, title, description, dueDate, isCompleted));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서 -> 역순)
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return todos;
	}

	// id에 해당하는 한 개의 Todo 데이터 조회
	public Todo findById(int todoId) {
		Todo todo = null;
		ResultSet rs = null;

		// Java7 이후 방식 try-with-resources 문법
		// try () 소괄호 내부에 작성한 JDBC 객체들은 자동으로 자원이 반납됨(close()를 사용하지 않아도 됨)
		// JDBC 객체 이외에 자원 반납이 필요한 다른 객체들도 동일하게 사용 가능
		// 조건, AutoCloseable 인터페이스를 구현한 클래스만 사용 가능
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from todo where id = ?");) {

			statement.setInt(1, todoId); // ?에 맵핑(바인딩)할 값을 지정, 좌측부터 물음표 개수만큼 넘버링 지정
			rs = statement.executeQuery();

			rs.next();
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			Date dueDate = rs.getDate("due_date");
			int isCompleted = rs.getInt("is_completed");

			todo = new Todo(id, title, description, dueDate.toLocalDate(), isCompleted == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {

			}
		}

		return todo;
	}

	// Todo 저장
	public void insertTodo() {
		final String InsertTodo = "Insert into todo(title,description,due_date,is_completed) values(\"삽입해볼게\",\"ddd\",\"2023-06-15\",false);";
		try {
			// DB와의 연결 객체 생성
			connection = DBUtil.getConnection();

			// 쿼리 전달해주는 객체
			statement = connection.createStatement();

			// 결과 데이터 출력(View)
			statement.execute(InsertTodo); // 쿼리 수행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서 -> 역순)
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Todo 수정
	public void updateTodo() {
		final String InsertTodo = "update todo set title=\"수정 해볼게\" where id=22;";

		try {
			// DB와의 연결 객체 생성
			connection = DBUtil.getConnection();

			// 쿼리 전달해주는 객체
			statement = connection.createStatement();

			// 결과 데이터 출력(View)
			boolean result = statement.execute(InsertTodo); // 쿼리 수행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 자원 반납, 해제(순서 -> 역순)
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}