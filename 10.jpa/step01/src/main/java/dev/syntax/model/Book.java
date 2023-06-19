package dev.syntax.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * JPA������ Entity��� ������ Ȱ��
 * �ڹ� �ν��Ͻ�(Object) - DB ���̺��� �ϳ��� �� Row�� �ϳ��� Entity��� �����
 */

@Entity // Book Ŭ������ JPA�� �����ϴ� Entity�� �ν��ϰ� ��
public class Book {

	/*
	 * JPA �⺻ Ű ���� ���� 1. ���� �Ҵ�: �⺻Ű ���� ���ø����̼� �ڵ忡��(Java �ڵ��) ���� �Ҵ� ex) int id = 1,
	 * id++ �� 2. �ڵ� ����: DB�� ���� �������ִ� ��� 1) IDENTITY: �⺻ Ű�� ������ DB���� ����(MySQL��
	 * AUTO_INCREMENT) 2) SEQUENCE: DB�� �������� ����ؼ� �⺻Ű �Ҵ�(����Ŭ���� ����, MySQL�� ����x) 3)
	 * TABLE: Ű ������ ������ ���̺��� ���, ������ó�� ����ϴ� ���, ���̺��� ����ϱ� ������ ��� DB���� ��� ���� 4) AUTO:
	 * DB�� �´� PK �� ���� ������ �ڵ����� ����(������ strategy�� �߰����� ������ �⺻���� AUTO)
	 * 
	 * ���� �Ҵ� ����� ����Ϸ��� @Id�� ����ϸ� �ǰ�, �ڵ� ���� ������ ����Ϸ��� @Id + @GeneratedValue�� �߰��ϰ� ���ϴ�
	 * Ű ���� ������ �Ķ���ͷ� �����ϸ� ��
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "book_name", nullable = false)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pub_date")
	private Date pubDate;

	private String author;

	protected Book() {
		super();
	}

	public Book(String name, Date pubDate) {
		super();
		this.name = name;
		this.pubDate = pubDate;
	}

	public Book(String name, String author, Date pubDate) {
		super();
		this.name = name;
		this.pubDate = pubDate;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pubDate=" + pubDate + ", author=" + author + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
}
