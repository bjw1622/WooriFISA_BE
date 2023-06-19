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
		 * EntityManger�� �����ϱ� ���� ��ü
		 * Persistence unit�� persistence.xml ���Ͽ� ���� ���� ������ �����
		 * */
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");
		
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		/*
		 * ��������� Bokok ���̺��� ����� ���ؼ��� ���� create table book
		 * JPA�� Ȱ���� ���, Book�̶�� �̸��� Ŭ������ ������ ����,
		 * ���̺��� �÷����� ���ε� �� �ִ� �� ���� ������ �ۼ��ϸ� �ڵ����� ��  ������ �°� ���̺��� ������
		 * */
		
		try {
			transaction.begin();
			// Book ��ü(��ƼƼ) ����
			Book book = new Book("���ǽ�",Date.valueOf("1995-05-21"));
			manager.persist(book);
			transaction.commit();
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
		finally {
			manager.close(); // ���������� Connection ��ü�� �ݳ�
			factory.close();
		}
	}
}
