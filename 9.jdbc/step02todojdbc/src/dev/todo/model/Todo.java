package dev.todo.model;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String title; // 할 일 제목
	private String description; // 할 일 내용
	private LocalDate dueDate; // 할 일 마감기간
	private boolean isCompleted; // 진행 여부

	public Todo(int id, String title, String description, LocalDate dueDate, boolean isCompleted) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.isCompleted = isCompleted;

	}

	public Todo(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.dueDate = builder.dueDate;
		this.isCompleted = builder.isCompleted;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", isCompleted=" + isCompleted + "]";
	}

	// 빌더 (Builder) 패턴
	public static class Builder {
		private int id;
		private String title; // 할 일 제목
		private String description; // 할 일 내용
		private LocalDate dueDate; // 할 일 마감기간
		private boolean isCompleted; // 진행 여부

		// id 를 필드로 받는 생성자
		public Builder(int id) {
			this.id = id;
		}

		// 일반 메서드 tiotle() 반환타입이 Builder
		public Builder title(String title) {
			this.title = title;
			return this;
		}

		// description(), dueDate(), isCompleted() 작성
		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder dueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
			return this;
		}

		public Builder isCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
			return this;
		}

		public Todo build() {
			return new Todo(this);
		}
	}
}