package dev.syntax;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Major {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인크리먼트
	@Column(name = "major_id")
	private int id;
	@Column(name = "major_name", nullable = false)
	private String majorNmae;

	protected Major() {
		super();
	}

	public Major(String name) {
		this.majorNmae = name;
	}

	public Major(int id, String name) {
		this.id = id;
		this.majorNmae = name;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorNmae=" + majorNmae + "]";
	}

}