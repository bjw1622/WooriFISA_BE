package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step03FindEntity {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		// SELECT는 transaction 필요X
		// id가 1인 레코드(엔티티) 조회
		// Record : DB 맥락에서의 데이터, 한 개의 튜플, 
		Book book = manager.find(Book.class, 1);
		
	}

}
