package dev.syntax;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

public class Step02RDBWayTest {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("step01");

	EntityManager manager = factory.createEntityManager();

	EntityTransaction transaction = manager.getTransaction();

	@Test
	public void testSave() {
		transaction.begin();
		// 학과 데이터 저장
		Major major = new Major("컴퓨터 공학");
		manager.persist(major);

		// 학생 1 생성, 저징
		Student kim = new Student("민수");
		kim.setMajor(major);
		manager.persist(kim);

		// 학생 2 생성, 저징
		Student yoon = new Student("동열");
		yoon.setMajor(major);
		manager.persist(yoon);
		
		transaction.commit();
	}

	@Test
	public void testRead() {
		Student student = manager.find(Student.class, 1);
		System.out.println(student);
		
		Major major = student.getMajor();
		System.out.println(major);
		
		System.out.println(major.getMajorNmae());
	}

	@Test
	public void testUpdateRelation() {
		transaction.begin();
		
		// 새로운 전공 국문학과
		Major major = new Major("국문학과");
		manager.persist(major);
		
		// 학번이 1인 학생(민수)의 전공을 국문학과로 변경
		Student kim = manager.find(Student.class, 1);
		kim.setMajor(major);
		transaction.commit();
	}

	@Test
	public void testDeleteEntity() {
		transaction.begin();
		
		Student student = manager.find(Student.class,1);
		student.setMajor(null);
		Major major = manager.find(Major.class, 2);
		manager.remove(major);
	}

}
