package dev.todo;

import java.time.LocalDate;

import dev.todo.controller.TodoController;
import dev.todo.model.Todo;

public class App {

   public static void main(String[] args) {
      TodoController todoController = new TodoController();
      todoController.findById(3);
      todoController.insertTodo();
      todoController.updateTodo();
      todoController.findAll();
   }
}
