package dev.syntax;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class App {

	public static void main(String[] args) {
		/*
		 * EntityManger를 생성하기 위한 객체
		 * Persistence unit인 persistence.xml 파일에 의해 설정 정보가 적용됨
		 * */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		/*
		 * 기ㅣ존에는 Bokok 테이블을 만들기 위해서는 직접 create table book
		 * JPA를 활용할 경우, Book이라는 이름의 클래스를 생성한 다음,
		 * 테이블의 컬럼으로 맵핑될 수 있는 몇 가지 정보를 작성하면 자동으로 그  정보에 맞게 테이블이 생성됨
		 * */
		
		try {
			transaction.begin();
			// Book 객체(엔티티) 생성
			Book book = new Book("원피스",Date.valueOf("1995-05-21"));
			manager.persist(book);
			transaction.commit();
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		finally {
			manager.close(); // 내부적으로 Connection 객체를 반납
			factory.close();
		}
	}
}
