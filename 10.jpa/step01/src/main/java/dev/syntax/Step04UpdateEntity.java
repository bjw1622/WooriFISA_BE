package dev.syntax;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.syntax.model.Book;

public class Step04UpdateEntity {
	
	/*
	 * ��ƼƼ ��(Java������ Entity Ŭ������ �ʵ�, DB�� ���� �÷�)�� ����(����)
	 * UPDATE Query
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			 transaction.begin(); // BEGIN
			 Book book = manager.find(Book.class, 1);
			 System.out.println(book);
			 
			 // JPA������ ������ UPDATE�� ���� �޼��带 �������� ����
			 book.setName("ABC"); // Book�� �̸��� JPA���� ABC�� ����
			 manager.persist(book); // TODO: persist�� ���� �ʾƵ� ���� ���� �߻�
			 transaction.commit(); // COMMIT;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
		}
	}
}