package dev.syntax;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
	@Column(name = "student_id")
	private int id;

	@Column(name = "student_name", nullable = false)
	private String studentName;

	@ManyToOne // 여러명의 학생은 하나의 전공은 가질 수 있다
	@JoinColumn(name = "major_id")
	// -> 외래키 매핑 시 사용, name 속성에 맵핑할 외래키 이름 지정;
	private Major major;

	public Student() {
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(int id, String studentName) {
		super();
		this.id = id;
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}

//	@Column(name = "book_name", nullable = false)
//	private String name;
}