package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step05DeleteEntity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			 transaction.begin(); // BEGIN
			 Book book = manager.find(Book.class, 1);
			 manager.remove(book);
			 transaction.commit(); // COMMIT;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			manager.close();
			factory.close();
		}
	}

}
