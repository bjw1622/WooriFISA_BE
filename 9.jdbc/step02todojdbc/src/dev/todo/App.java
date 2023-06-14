package dev.todo;

import dev.todo.controller.TodoController;
import dev.todo.model.Todo;
import dev.todo.model.Todo.Builder;

public class App {

	static TodoController todoController;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		todoController = new TodoController();
//		Todo todo=todoController.findById(2);
//		System.out.println(todo);

		new Todo.Builder(8).title("밥묵자").description("밥을 먹는다").build();

		Todo todo2 = new Todo.Builder(2).title("물마시기").isCompleted(false).build();

	}

}