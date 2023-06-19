package dev.syntax;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import dev.syntax.model.Book;

class Step06PCLifeCycleTest {
	
	// �׽�Ʈ�� ���� �⺻ ����
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();

	@Test
	void testPersist��_������_���_��ƼƼ��_����ȭ�ǰ�_commit��_�����_���_DB��_����ȴ�() {
		transaction.begin();
		
		Book jpaBook = new Book("JPA", "����", new Date());
		manager.persist(jpaBook);
		
		transaction.commit();
		
		Book foundBook = manager.find(Book.class, jpaBook.getId());
		System.out.println(jpaBook == foundBook);
		assertEquals(jpaBook, foundBook); // ������
	}

	@Test
	void test�ѹ�_����ȭ��_��ƼƼ��_�ٽ�_��ȸ��_DB��_�ƴ�_���Ӽ����ؽ�Ʈ����_��ȸ�ȴ�() {
		int id = 1;
		
		Book foundBook = manager.find(Book.class, id);
		System.out.println(foundBook);
		
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertEquals(foundBook, foundBookTwice);
	}

	@Test
	void test��ƼƼ��_����_�����ϰ�_commit�ϸ�_���氨����_�߻��Ǿ�_UPDATE������_����ȴ�() {
		int id = 1;
		transaction.begin();
		Book foundBook = manager.find(Book.class, id);
		foundBook.setName("ABC"); // foundBook ��ƼƼ�� ������ ����
		transaction.commit();
	}

	@Test
	void test����_��ƼƼ��_detach�Ұ��_�ʵ���_����_�����ص�_UPDATE������_�������_�ʴ´�() {
		int id = 1;
		transaction.begin();
		
		// id�� 1���� ��ƼƼ ��ȸ
		Book foundBook = manager.find(Book.class, id);
		foundBook.setName("QAW");
		
		manager.detach(foundBook); // foundBook ��ƼƼ�� PC���� �и�(detach)
		// update ���� ���� �ȵ�
		
		transaction.commit(); 
		
		// ���Ӽ� ���ؽ�Ʈ���� ���ŵǾ��� ������ �ٽ� SELECT�� �����
		Book foundBookTwice = manager.find(Book.class, id);
		assertNotEquals(foundBook, foundBookTwice);
	}

	@Test
	void testRemove��_�����Ұ��_PC��_DB����_�����Ͱ�_���ŵȴ�() {
		int id = 2;
		transaction.begin();
		Book foundBook = manager.find(Book.class, id);
		manager.remove(foundBook);
		
		transaction.commit();
		
		// JS, () => {}, fat arrow
		assertThrows(NullPointerException.class, () -> {// In java, Thin Arrow(() -> {})
			
			// ������ remove�� �Ǿ��� ������ select�� ������ �������� �ʰ�, null�� �Ҵ��
			Book foundBookTwice = manager.find(Book.class, id);
			// null.updateBookName()�� �����߱� ������ nullPointer �߻�(�׽�Ʈ ����)
			foundBookTwice.setName("Effective Unit Testing");
			
			// PC�� ���������� SELECT�� �������� �ʱ� ������ ������ �ִ� ��ƼƼ�� �� �� true�� ���� ��
			// -> Ȯ�� ���, �������� ����
			
			// 'foundBook == foundBookTwice ������ ����� false�� ���̴�'��� ������
			assertFalse(foundBook == foundBookTwice);
			
		});
	}

	@Test
	void test���Ӽ����ؽ�Ʈ��_�ʱ�ȭ�Ұ��_���_��ƼƼ��_���ŵ�() {
		int id = 3;
		
		Book foundBook = manager.find(Book.class, id);
		
		manager.clear(); // PC �� �� û����, ��ƼƼ ��� ġ��
		
		Book foundBookTwice = manager.find(Book.class, id);
		
		assertFalse(foundBook == foundBookTwice);
	}

	@Test
	void test��ƼƼ�Ŵ�����_���ŵ�() {
		System.out.println(manager);

		manager.close(); // ��ƼƼ �Ŵ��� ��ü�� ����, PC�� ���ŵ�		
		System.out.println(manager);
	}

}
